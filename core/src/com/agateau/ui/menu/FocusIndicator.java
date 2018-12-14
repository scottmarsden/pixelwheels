/*
 * Copyright 2018 Aurélien Gâteau <mail@agateau.com>
 *
 * This file is part of Pixel Wheels.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License.
 *
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.  See the
 * License for the specific language governing permissions and limitations
 * under the License.
 */
package com.agateau.ui.menu;

import com.agateau.utils.AgcMathUtils;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

public abstract class FocusIndicator {
    private static final float IN_ANIMATION_DURATION = 0.1f;
    private static final float OUT_ANIMATION_DURATION = 0.4f;
    private final Menu mMenu;
    private final Image mImage;

    public FocusIndicator(Menu menu) {
        mMenu = menu;
        mImage = new Image(menu.getMenuStyle().focus);
        mImage.setTouchable(Touchable.disabled);
        mImage.setColor(1, 1, 1, 0);
        menu.getStage().addActor(mImage);
    }

    public void setFocused(boolean focused) {
        mImage.clearActions();
        if (focused) {
            updateBounds();
            mImage.addAction(Actions.alpha(1, IN_ANIMATION_DURATION));
        } else {
            mImage.addAction(Actions.alpha(0, OUT_ANIMATION_DURATION));
        }
    }

    public void updateBounds() {
        float padding = mMenu.getMenuStyle().focusPadding;
        Rectangle rect = getBoundsRectangle();
        AgcMathUtils.adjustRectangle(rect, padding);
        mImage.setBounds(rect.x, rect.y, rect.width, rect.height);
    }

    /**
     * Must return the bounds of the focused area, in stage coordinates
     */
    abstract protected Rectangle getBoundsRectangle();
}
