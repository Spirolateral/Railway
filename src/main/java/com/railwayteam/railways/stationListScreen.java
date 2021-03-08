package com.railwayteam.railways;

import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.widget.button.Button;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;

public class stationListScreen extends AbstractRailwaysScreen<StationListContainer> {

  private ResourceLocation BG = new ResourceLocation(Railways.MODID, "textures/gui/schedule_bg.png");
  private ResourceLocation FG = new ResourceLocation(Railways.MODID, "textures/gui/schedule_fg.png");
  private boolean pressed = false;

  private static final int buttonWidth  = 80;
  private static final int buttonHeight = 20;
  private static final int buttonX = 20;
  private static final int buttonY = 100;

  protected stationListScreen(StationListContainer container, PlayerInventory inv, ITextComponent title) {
    super (container, inv, title);
  }

  @Override
  protected void init () {
    super.init();
    widgets.add(new Button(buttonX, buttonY, buttonWidth, buttonHeight, "Press me!", button->{
      this.pressed = !pressed;
      button.setMessage("Press again!");
    }));
  }

  @Override
  protected void renderWindow (int mouseX, int mouseY, float partialTicks) {
    drawString (Minecraft.getInstance().fontRenderer, "Test GUI!", 10,10, 0xffffff);
  }

  @Override
  protected void drawGuiContainerBackgroundLayer (float partialTicks, int mouseX, int mouseY) {
    RenderSystem.color4f(1.0f, 1.0f, 1.0f, 1.0f);
    minecraft.getTextureManager().bindTexture(pressed ? FG : BG);
    RenderSystem.scaled(0.7d, 0.7d, 1d);
    int relX = (width - getXSize()) / 2 + 200;
    int relY = (height- getYSize()) / 2;
    blit(relX,relY, 0,0, (int)Math.floor(getXSize()*1.5),(int)Math.floor(getYSize()*1.54));
  }

  @Override
  public void tick () {
    super.tick();
  }

  @Override
  public boolean mouseClicked (double x, double y, int button) {
    boolean mouseClicked = super.mouseClicked(x,y,button);
  //  if (button == 0) {
  //    minecraft.player.closeScreen();
  //    mouseClicked = true;
  //  }
    return mouseClicked;
  }
}