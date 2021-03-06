/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bullet;

import Entity.Entity;
import Entity.Id;
import Sound.SoundHandler;
import Target.AiHouse;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import tile.Tile;

import java.util.LinkedList;

/**
 *
 * @author khoinguyen
 */
public class FireBall extends Bullet{
    private LinkedList<Tile> copiedTile;
    public FireBall(double x, double y,BulletHandler bulletHandler,Boolean flyingLeft) {
        super(x, y,bulletHandler,flyingLeft);
        this.setId(bulletType.fireBall);

    }

    public FireBall(BulletHandler bulletHandler, bulletType id) {
        super(bulletHandler, id);
    }

    @Override
    public void renderBullet(GraphicsContext gc, Entity en,Image imageLeft, Image imageRight) {
        if(en.getFacing() == 0){
            gc.drawImage(imageLeft, this.getX(),this.getY(),this.getWidth() , this.getHeight());
        }
        else if(en.facing == 1){
            gc.drawImage(imageRight, this.getX(), this.getY(), this.getWidth(), this.getHeight());
        }
    }

    @Override
    public void tick(long currenttime) {
        this.setX(this.getX() + this.getVelX());
        this.setY(this.getY() + this.getVelY());
        //check if fireball collides tiles
        tileCollidingChecking();
        //check if this collides entities
        entityCollidingChecking();
        //check if this collides houses
        houseCollidingCheck();

    }
    public void tileCollidingChecking(){
        copiedTile = new LinkedList<>(tileHandler.getTile());
        for(Tile t: copiedTile)  {
            if(t.solid == false){
            }
            else if(t.getId() == Id.wall){
                if(this.intersectsTile(t)){
                    if(t.getType().equalsIgnoreCase("wall3")){
                        t.die();
                    }
                    if(t.getType().equalsIgnoreCase("dWall2")){
                        t.setHp(t.getHp() -200);
                    }
                    if(!t.getType().equalsIgnoreCase("wall3")){
                        this.disappear();
                    }
                }
            }
        }
    }
    public void entityCollidingChecking(){
        for(Entity en : entityHandler.getEntity()){
            if(en.getId() == Id.Goomba || en.getId() == Id.GoombaBoss || en.getId() == Id.Eagle){
                if(this.intersectsEntity(en)){
                    if(en.getId() == Id.Eagle){
                        en.setHp(en.getHp()- 1000); //1000
                    }
                    else {
                        en.setHp(en.getHp()-200); //200
                    } 
                    SoundHandler.getInstance().playSound("monster_hurt");
                    this.disappear();
                }
            }
        }
    }
    public void houseCollidingCheck(){
        for(AiHouse aiHouse : houseHandler.getAiHouses()){
            if(this.intersectsHouse(aiHouse)){
                aiHouse.setHp(aiHouse.getHp()-200); //200
                this.disappear();
            }
        }
    }
}
