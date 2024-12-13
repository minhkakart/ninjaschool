package com.minhkakart.ninjaschool.game.models;

import com.minhkakart.ninjaschool.game.configurations.GlobalConfig;
import com.minhkakart.ninjaschool.game.enums.MapInfo;
import com.minhkakart.ninjaschool.game.enums.NumberFontColor;
import com.minhkakart.ninjaschool.game.interfaces.Drawable;
import com.minhkakart.ninjaschool.game.managers.MapManager;
import com.minhkakart.ninjaschool.game.managers.ResourceManager;
import com.minhkakart.ninjaschool.game.supports.Drawer;
import com.minhkakart.ninjaschool.game.supports.TextSupporter;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import static com.minhkakart.ninjaschool.game.models.MapAssetPart.MAP_PART_HEIGHT;
import static com.minhkakart.ninjaschool.game.models.MapAssetPart.MAP_PART_WIDTH;

@SuppressWarnings("CallToPrintStackTrace")
public class MapObject implements Drawable {
    private int[][] viewData;
    private byte[][] collisionData;
    private WaterAnimation waterAnimation = null;
    private WaterFallAnimation waterFallAnimation = null;
    private Point startPoint;
    private static final Rectangle VIEW_RECT = new Rectangle(-MAP_PART_WIDTH, -MAP_PART_HEIGHT, GlobalConfig.ORIGINAL_WIDTH + MAP_PART_WIDTH, GlobalConfig.ORIGINAL_HEIGHT + MAP_PART_HEIGHT);

    public MapObject() {
        this.viewData = new int[0][0];
        this.collisionData = new byte[0][0];
        this.startPoint = new Point(0, 0);
    }

    public static MapObject loadMap(MapInfo mapInfo) {
        MapManager.setCurrentMap(mapInfo);
        MapObject mapObject = new MapObject();
        InputStream inputStream = null;
        BufferedReader bufferedReader = null;

        try {
            inputStream = ResourceManager.getInputStream(mapInfo.getDataPath());
            bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            int row = Integer.parseInt(bufferedReader.readLine().trim().split("=")[1]);
            int col = Integer.parseInt(bufferedReader.readLine().split("=")[1]);
            mapObject.viewData = new int[row][col];
            System.out.println("row: " + row + " col: " + col);
            for (int i = 0; i < row; i++) {
                String[] line = TextSupporter.trimFull(bufferedReader.readLine()).split(" ");
                for (int j = 0; j < col; j++) {
                    mapObject.viewData[i][j] = Integer.parseInt(line[j]);
                }
            }
            /* Old code
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    System.out.print(String.format("%4d ", mapAssets[i][j]));
                }
                System.out.println();
            }
            */
            
            // Start point
            bufferedReader.readLine(); // Skip title
            String[] startPoint = bufferedReader.readLine().split(",");
            mapObject.startPoint = new Point(Integer.parseInt(startPoint[0]), Integer.parseInt(startPoint[1]));

            // WaterFallAnimation
            bufferedReader.readLine(); // Skip title
            Point[] topPositions = readPointsLineData(bufferedReader.readLine()); // Read top positions
            Point[] bodyPositions = readPointsLineData(bufferedReader.readLine()); // Read body positions
            mapObject.waterFallAnimation = new WaterFallAnimation(topPositions, bodyPositions, mapObject.startPoint);

            // WaterAnimation
            bufferedReader.readLine(); // Skip title
            Point[] waterPositions = readPointsLineData(bufferedReader.readLine()); // Read water positions
            mapObject.waterAnimation = new WaterAnimation(waterPositions, mapObject.startPoint);
            
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
                if (inputStream != null) {
                    inputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return mapObject;
    }

    private static Point[] readPointsLineData(String line) throws IOException {
        String[] waterFallBodyPositionArray = line.split(";");
        Point[] positions = new Point[waterFallBodyPositionArray.length];
        for (int i = 0; i < waterFallBodyPositionArray.length; i++) {
            String[] position = waterFallBodyPositionArray[i].split(",");
            positions[i] = new Point(Integer.parseInt(position[0]) * MAP_PART_WIDTH, Integer.parseInt(position[1]) * MAP_PART_HEIGHT);
        }
        return positions;
    }
    
    public void destroy() {
        if (waterAnimation != null) {
            waterAnimation.destroy();
        }
        if (waterFallAnimation != null) {
            waterFallAnimation.destroy();
        }
    }

    public void move(int dx, int dy) {
        startPoint.translate(dx, dy);
        waterAnimation.move(dx, dy);
        waterFallAnimation.move(dx, dy);
    }

    @Override
    public void draw(Graphics2D graphics2D) {
        if (viewData == null) {
            return;
        }

        for (int i = 0; i < viewData.length; i++) {
            for (int j = 0; j < viewData[i].length; j++) {
                if (VIEW_RECT.contains(new Point(j * MAP_PART_WIDTH + startPoint.x, i * MAP_PART_HEIGHT + startPoint.y))) {
                    if (viewData[i][j] != 0) {
                        graphics2D.drawImage(MapAssetPart.GetPartImage(viewData[i][j]), j * MAP_PART_WIDTH + startPoint.x, i * MAP_PART_HEIGHT + startPoint.y, null);
                        Drawer.drawIntegerRaw(viewData[i][j], j * MAP_PART_WIDTH + startPoint.x, i * MAP_PART_HEIGHT + startPoint.y + 10, graphics2D, NumberFontColor.YELLOW);
                    }
                }
            }
        }

        if (waterFallAnimation != null)
            waterFallAnimation.draw(graphics2D);

        if (waterAnimation != null)
            waterAnimation.draw(graphics2D);
    }
}
