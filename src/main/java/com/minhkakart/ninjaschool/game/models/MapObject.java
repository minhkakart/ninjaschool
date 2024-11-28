package com.minhkakart.ninjaschool.game.models;

import com.minhkakart.ninjaschool.game.configurations.GlobalConfig;
import com.minhkakart.ninjaschool.game.enums.MapId;
import com.minhkakart.ninjaschool.game.enums.NumberFontColor;
import com.minhkakart.ninjaschool.game.interfaces.Drawable;
import com.minhkakart.ninjaschool.game.managers.ResourceManager;
import com.minhkakart.ninjaschool.game.supports.Drawer;
import com.minhkakart.ninjaschool.game.supports.TextSupporter;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import static com.minhkakart.ninjaschool.game.models.MapAssetPart.PART_HEIGHT;
import static com.minhkakart.ninjaschool.game.models.MapAssetPart.PART_WIDTH;

public class MapObject implements Drawable {
    private int[][] viewData;
    private byte[][] collisionData;
    private WaterAnimation waterAnimation1 = new WaterAnimation(new Point(13 * PART_WIDTH, 17 * PART_HEIGHT), 20);
    private WaterAnimation waterAnimation2 = new WaterAnimation(new Point(97 * PART_WIDTH, 18 * PART_HEIGHT), 12);
    private WaterFallAnimation waterFallAnimation1 = new WaterFallAnimation(new Point(100 * PART_WIDTH, 14 * PART_HEIGHT),
            new Point[]{
                    new Point(100 * PART_WIDTH, 15 * PART_HEIGHT)
            });
    private WaterFallAnimation waterFallAnimation2 = new WaterFallAnimation(new Point(100 * PART_WIDTH, 16 * PART_HEIGHT),
            new Point[]{
                    new Point(100 * PART_WIDTH, 17 * PART_HEIGHT),
                    new Point(100 * PART_WIDTH, 18 * PART_HEIGHT)
            });
    private WaterFallAnimation waterFallAnimation3 = new WaterFallAnimation(new Point(104 * PART_WIDTH, 14 * PART_HEIGHT),
            new Point[]{
                    new Point(104 * PART_WIDTH, 15 * PART_HEIGHT),
                    new Point(104 * PART_WIDTH, 17 * PART_HEIGHT),
                    new Point(104 * PART_WIDTH, 18 * PART_HEIGHT)
            });

    private Point startPoint;
    private static final Rectangle VIEW_RECT = new Rectangle(-PART_WIDTH, -PART_HEIGHT, GlobalConfig.ORIGINAL_WIDTH + PART_WIDTH, GlobalConfig.ORIGINAL_HEIGHT + PART_HEIGHT);

    public MapObject() {
        this.viewData = new int[0][0];
        this.collisionData = new byte[0][0];
        this.startPoint = new Point(0, 0);
    }

    public static MapObject loadMapObject(MapId mapId) {
        MapObject mapObject = new MapObject();
        InputStream inputStream = null;
        BufferedReader bufferedReader = null;

        try {
//                inputStream = Files.newInputStream(Paths.get(ResourceManager.getMapAssetDataPath(mapData.getMapName())));
            inputStream = ResourceManager.getInputStream(mapId.getDataPath());
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

    public void move(int dx, int dy) {
        startPoint.translate(dx, dy);
        waterAnimation1.move(dx, dy);
        waterAnimation2.move(dx, dy);
        waterFallAnimation1.move(dx, dy);
        waterFallAnimation2.move(dx, dy);
        waterFallAnimation3.move(dx, dy);
    }

    @Override
    public void draw(Graphics2D graphics2D) {
        if (viewData == null) {
            return;
        }
        waterFallAnimation1.draw(graphics2D);
        waterFallAnimation2.draw(graphics2D);
        waterFallAnimation3.draw(graphics2D);
        for (int i = 0; i < viewData.length; i++) {
            for (int j = 0; j < viewData[i].length; j++) {
                if (VIEW_RECT.contains(new Point(j * PART_WIDTH + startPoint.x, i * PART_HEIGHT + startPoint.y))) {
                    if (viewData[i][j] != 0) {
                        graphics2D.drawImage(MapAssetPart.GetPartImage(viewData[i][j]), j * PART_WIDTH + startPoint.x, i * PART_HEIGHT + startPoint.y, null);
                        Drawer.drawIntegerRaw(viewData[i][j], j * PART_WIDTH + startPoint.x, i * PART_HEIGHT + startPoint.y + 10, graphics2D, NumberFontColor.YELLOW);
                    }
                }
            }
        }

        waterAnimation1.draw(graphics2D);
        waterAnimation2.draw(graphics2D);
    }
}
