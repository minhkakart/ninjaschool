package com.minhkakart.ninjaschool.game.components;

import com.minhkakart.ninjaschool.game.enums.ButtonSize;
import com.minhkakart.ninjaschool.game.enums.StringFont;
import com.minhkakart.ninjaschool.game.managers.ResourceManager;
import com.minhkakart.ninjaschool.game.supports.Drawer;

import java.awt.*;

public class SmallButton extends GameButton{
    public SmallButton(String name, Point position) {
        super(name, position);
    }

    @Override
    public Rectangle getBound() {
        return new Rectangle(position.x, position.y, ButtonSize.SMALL_BUTTON.getWidth(), ButtonSize.SMALL_BUTTON.getHeight());
    }

    @Override
    public void draw(Graphics2D graphics2D) {
        if (isFocused()){
            graphics2D.drawImage(ResourceManager.getSmallButton(1), position.x, position.y, null);
        } else {
            graphics2D.drawImage(ResourceManager.getSmallButton(0), position.x, position.y, null);
        }

        Drawer.drawStringCentered(name, getBound(), graphics2D, StringFont.TAHOMA_7B_YELLOW);
    }
}
