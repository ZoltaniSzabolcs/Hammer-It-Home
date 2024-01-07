package game.platformNails;

import java.awt.*;

public class PlatformNailsView {
    private PlatformNailsModel platformNailsModel;
    public PlatformNailsView(PlatformNailsModel platformNailsModel){
        this.platformNailsModel = platformNailsModel;
    }
    public void initDraw(Graphics g){
        g.drawImage(platformNailsModel.getLineImg(), platformNailsModel.getPlatformPosition().x + 1,0, platformNailsModel.getLineImg().getWidth(), platformNailsModel.getLineImg().getHeight(), null);
    }

    private void drawNail(Graphics g, Nail nail){
        g.drawImage(platformNailsModel.getNailImg()[nail.getCurrentImg()], nail.getPosition().x, nail.getPosition().y, platformNailsModel.getNailImg()[nail.getCurrentImg()].getWidth() / 2, platformNailsModel.getNailImg()[nail.getCurrentImg()].getHeight() / 2, null);
    }
    public void draw(Graphics g){
//      Draw every nail
        platformNailsModel.getNails().forEach(nail -> drawNail(g, nail));

//      Draw the overhanging part of the platform
        if(platformNailsModel.getPlatformPosition().x + platformNailsModel.getPlatformImg().getWidth() / 2  > platformNailsModel.getScreenWidth()) {
            g.drawImage(platformNailsModel.getPlatformImg(), platformNailsModel.getPlatformPosition().x - platformNailsModel.getScreenWidth(), platformNailsModel.getPlatformPosition().y, platformNailsModel.getPlatformImg().getWidth() / 2, platformNailsModel.getPlatformImg().getHeight() / 2, null);
        }

//      Draw the platform
        g.drawImage(platformNailsModel.getPlatformImg(), platformNailsModel.getPlatformPosition().x, platformNailsModel.getPlatformPosition().y, platformNailsModel.getPlatformImg().getWidth() / 2, platformNailsModel.getPlatformImg().getHeight() / 2, null);

//      Check hitbox
        /*g.fillOval(platformNailsModel.getInit().x, platformNailsModel.getInit().y, 10, 10);
        g.setColor(Color.RED);
        g.fillOval(platformNailsModel.getBeforeEnd(), platformNailsModel.getInit().y + platformNailsModel.getNailImg()[0].getHeight() / 2, 10, 10);
        g.setColor(Color.GREEN);
        g.fillOval(platformNailsModel.getEnd(), platformNailsModel.getInit().y + platformNailsModel.getNailImg()[0].getHeight() / 2, 10, 10);*/

//      Draw the line
        g.drawImage(platformNailsModel.getLineImg(), 0,platformNailsModel.getInit().y + platformNailsModel.getNailImg()[0].getHeight() / 2 + platformNailsModel.getPlatformImg().getHeight() / 2, platformNailsModel.getLineImg().getWidth(), platformNailsModel.getLineImg().getHeight(), null);
//        g.drawImage(platformNailsModel.getPlatformImg(),0,0, platformNailsModel.getPlatformImg().getWidth() / 2, platformNailsModel.getPlatformImg().getHeight() / 2, null);
    }
}
