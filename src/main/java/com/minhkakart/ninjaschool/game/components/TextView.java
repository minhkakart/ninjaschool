package com.minhkakart.ninjaschool.game.components;

import com.minhkakart.ninjaschool.game.enums.BorderIndex;
import com.minhkakart.ninjaschool.game.enums.ButtonSize;
import com.minhkakart.ninjaschool.game.enums.GameColor;
import com.minhkakart.ninjaschool.game.enums.StringFont;
import com.minhkakart.ninjaschool.game.managers.ResourceManager;
import com.minhkakart.ninjaschool.game.supports.Drawer;
import com.minhkakart.ninjaschool.game.supports.TextSupporter;

import java.awt.*;

@SuppressWarnings("unused")
public class TextView extends GameButton {

    public TextView(String name) {
        super(name);
        btnWidth = ButtonSize.START_BUTTON.getWidth();
        btnHeight = ButtonSize.START_BUTTON.getHeight();
    }

    public TextView(String name, Point position) {
        super(name, position);
        btnWidth = ButtonSize.START_BUTTON.getWidth();
        btnHeight = ButtonSize.START_BUTTON.getHeight();
    }

    @Override
    public void draw(Graphics2D graphics2D) {
        graphics2D.setClip(position.x, position.y, btnWidth, btnHeight);

        if (isFocused()) {
            graphics2D.setColor(GameColor.BUTTON_PRIMARY_CLICKED.getColor());
        } else {
            graphics2D.setColor(GameColor.BUTTON_PRIMARY.getColor());
        }
        graphics2D.fillRect(position.x + 2, position.y + 2, btnWidth - 4, btnHeight - 4);

        for (int i = 0; i < 17; i++) {
            graphics2D.drawImage(ResourceManager.getBorder(BorderIndex.TOP), position.x + ResourceManager.getBorder(BorderIndex.TOP_LEFT).getWidth() + i * ResourceManager.getBorder(BorderIndex.TOP).getWidth(), position.y, null);
            graphics2D.drawImage(ResourceManager.getBorder(BorderIndex.BOT), position.x + ResourceManager.getBorder(BorderIndex.BOT_LEFT).getWidth() + i * ResourceManager.getBorder(BorderIndex.BOT).getWidth(), position.y + (btnHeight - ResourceManager.getBorder(BorderIndex.BOT).getHeight()), null);
        }
        for (int i = 0; i < 2; i++) {
            graphics2D.drawImage(ResourceManager.getBorder(BorderIndex.LEFT), position.x, position.y + ResourceManager.getBorder(BorderIndex.TOP_LEFT).getHeight() + i * ResourceManager.getBorder(BorderIndex.LEFT).getHeight(), null);
            graphics2D.drawImage(ResourceManager.getBorder(BorderIndex.RIGHT), position.x + btnWidth - ResourceManager.getBorder(BorderIndex.RIGHT).getWidth(), position.y + ResourceManager.getBorder(BorderIndex.TOP_RIGHT).getHeight() + i * ResourceManager.getBorder(BorderIndex.RIGHT).getHeight(), null);

        }

        graphics2D.drawImage(ResourceManager.getBorder(BorderIndex.TOP_LEFT), position.x, position.y + 1, null);
        graphics2D.drawImage(ResourceManager.getBorder(BorderIndex.TOP_RIGHT), position.x + (btnWidth - ResourceManager.getBorder(BorderIndex.TOP_RIGHT).getWidth()), position.y + 1, null);
        graphics2D.drawImage(ResourceManager.getBorder(BorderIndex.BOT_LEFT), position.x, position.y + (btnHeight - ResourceManager.getBorder(BorderIndex.BOT_LEFT).getHeight()), null);
        graphics2D.drawImage(ResourceManager.getBorder(BorderIndex.BOT_RIGHT), position.x + (btnWidth - ResourceManager.getBorder(BorderIndex.BOT_RIGHT).getWidth()), position.y + (btnHeight - ResourceManager.getBorder(BorderIndex.BOT_RIGHT).getHeight()), null);

        graphics2D.drawImage(ResourceManager.getBorder(BorderIndex.PRIMARY), position.x + (btnWidth - ResourceManager.getBorder(BorderIndex.PRIMARY).getWidth()) / 2, position.y, null);

        Drawer.drawStringCentered(name, new Rectangle(position.x, position.y, btnWidth, btnHeight), graphics2D, StringFont.TAHOMA_7B_WHITE);
        
    }

    @Override
    public Rectangle getBound() {
        return new Rectangle(position.x, position.y, btnWidth, btnHeight);
    }

}