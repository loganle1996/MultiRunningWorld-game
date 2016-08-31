/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Map;


import Entity.AIenemy;
import Entity.Eagle;
import Target.AiHouse;
import Entity.EntityHandler;
import Entity.FinalBoss;
import Entity.Id;
import Entity.Player;
import Items.ItemHandler;
import Target.HouseHandler;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import tile.Portal;
import tile.Tile;
import tile.TileCache;
import tile.TileHandler;
import tile.Trap1;
import tile.WoodBridge;

/**
 *
 * @author apple
 */
public class GameMap
{

    public String map[][];
    public ImageView image;
    public static Image character;
    static int xCoordinate = 0, yCoordinate = 0;
    static int squareSize = 40;
    public Tile clonedTile;
    public Tile clonedTile1,clonedTile2,clonedTile3;
    public Trap1 clonedTile4;
    public Player player1 = Player.getInstance();
    public FinalBoss finalBoss = FinalBoss.getInstance();
    public AIenemy aienemy;
    public AiHouse aiHouse;
    public WoodBridge woodBridge;
    public Eagle eagle;
    public static Portal portal;
//    Image aiHouseImage = new Image("AiHouse.png");
    private static GameMap gameMap = new GameMap();
    EntityHandler entityHandler = EntityHandler.getInstance();
    public TileHandler tileHandler = TileHandler.getInstance();
    HouseHandler houseHandler = HouseHandler.getInstance();
    ItemHandler  itemHandler = ItemHandler.getInstance();
    //contructor
    private GameMap(){
    }
    public void getMapData2()
    {
        map = new String [][]{
            {"x","x","x","x","x","x","x","x","x","x","x","x","x","x","x","x","x","x","x","x","x","x","x","x","x","x","x","x","x","x","x","x","x","x","x","x","x","x","x","x"},
            {"x"," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," ","d","d","d"," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," ","x"},
            {"x"," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," ","F","g","d","F"," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," ","x"},
            {"x"," "," "," "," "," "," "," "," "," "," "," "," "," "," "," ","m","m","m","m","m"," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," ","x"},
            {"x"," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," ","x"},
            {"x","i"," "," "," "," "," "," "," "," "," "," "," "," "," "," "," ","-","-","-"," "," "," "," "," "," "," "," "," ","i"," "," "," "," "," "," "," "," "," ","x"},
            {"x"," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," ","m","m","m","x"},
            {"x","h"," "," "," "," "," "," "," ","i"," "," "," "," "," "," "," "," "," "," ","i"," "," "," "," "," "," "," "," "," "," "," "," "," "," "," ","m"," "," ","x"},
            {"x","m","m","m","m","m","m","m","m"," ","-","-"," "," "," ","m","m","m","m","m"," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," ","m"," "," ","x"},
            {"x"," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," ","i"," "," "," "," "," "," "," "," ","i"," "," "," "," "," "," ","d"," "," ","x"},
            {"x"," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," ","m","m","m","m","m","m","m","m","m"," "," "," "," ","m","m","m","m","m","x"},
            {"x"," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," ","x"},
            {"x"," "," "," "," "," "," "," "," "," "," "," "," "," ","-","-","-","-","-","-"," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," ","x"},
            {"x"," "," "," "," "," "," "," ","F"," "," "," "," "," "," "," "," "," "," ","i"," ","E"," "," "," "," "," "," "," "," "," "," "," ","F","i"," "," "," "," ","x"},
            {"x","m","m","m"," "," "," ","m","m","m"," "," "," ","m","m","m"," "," "," "," ","m","m","m","m","m","m","m","m","m","m","m","m","m","m"," "," "," ","m"," ","x"},
            {"x"," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," ","m","m"," "," "," ","x"},
            {"x"," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," ","x"},
            {"x"," "," "," "," "," "," "," "," "," ","-","-"," "," "," "," "," ","m","m"," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," ","m","m","m","x"},
            {"x"," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," ","F"," "," "," ","x"},
            {"x"," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," ","m","m","m"," "," "," ","x"},
            {"x"," "," ","m"," "," "," "," "," ","m","m"," "," "," "," ","i"," "," "," "," "," ","i"," "," "," "," "," "," "," "," "," "," ","m"," "," "," "," "," "," ","x"},
            {"x"," "," "," "," "," "," "," "," "," "," "," "," "," "," "," ","m","m","m","m","m"," "," "," "," ","F"," "," "," "," "," "," "," "," "," "," "," "," "," ","x"},
            {"x","i"," "," "," "," ","-","-"," "," "," "," "," "," "," "," "," "," "," "," "," "," "," ","m","m","m","m","m","m","m","m","m"," "," "," "," ","m","m","m","x"},
            {"x"," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," ","x"},
            {"x","m"," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," ","x"},
            {"x","m","m"," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," ","x"},
            {"x"," ","i"," "," "," "," "," "," "," ","-","-"," "," ","i"," "," ","-","-"," "," ","F","FR"," ","i"," "," "," "," "," "," "," "," "," "," "," "," "," "," ","x"},
            {"x"," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," ","m","m","m"," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," ","x"},
            {"x"," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," ","m"," "," "," ","FR"," "," "," "," "," "," "," "," "," "," "," "," ","x"},
            {"x"," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," ","m","m","m","m","m","m","m"," "," "," "," "," "," "," "," "," "," ","x"},
            {"x"," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," ","x"},
            {"x"," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," ","x"},
            {"x"," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," ","m","m","m","m"," "," "," "," "," "," "," ","x"},
            {"x"," "," "," "," "," "," "," "," "," ","i"," "," ","E"," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," ","i"," "," "," "," "," "," "," ","x"},
            {"x"," "," "," "," "," "," "," "," "," "," ","m","m","m","m"," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," ","m","m","m","m","m","m","m","x"},
            {"x","P"," "," "," "," "," "," "," "," ","m"," "," "," "," ","m"," "," "," "," "," "," "," "," "," "," "," "," "," "," ","i"," "," "," "," "," "," ","E"," ","x"},
            {"x","m","m"," "," ","-"," "," ","m","m","m","m"," "," "," ","m","m","-"," "," ","m","m","m","m","m","m"," ","-","-"," "," "," "," "," "," "," "," "," "," ","x"},
            {"x"," "," ","^","^","^","^","^","^","^","^","^","^"," "," "," ","^","^","^","^","^","^","^","^","^","^","^","^","^","^","^","^","^","^","^","^","^","^","^","x"},
            {"x","^","^","^","^","^","^","^","^","^","^","^","^","^","^","^","^","^","^","^","^","^","^","^","^","^","^","^","^","^","^","^","^","^","^","^","^","^","^","x"},
            {"x","x","x","x","x","x","x","x","x","x","x","x","x","x","x","x","x","x","x","x","x","x","x","x","x","x","x","x","x","x","x","x","x","x","x","x","x","x","x","x"}

        };
    }

    public void getMapData1()
    {
        map = new String [][]{
          {"x","x","x","x","x","x","x","x","x","x","x","x","x","x","x","x","x","x","x","x","x","x","x","x","x","x","x","x","x","x","x","x","x","x","x","x","x","x","x","x"},
          {"x"," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," ","x"},
          {"x"," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," ","x"},
          {"x"," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," ","x"},
          {"x"," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," ","x"},
          {"x"," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," ","x"},
          {"x"," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," ","d"," "," "," "," "," "," "," "," "," "," ","x"},
          {"x"," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," ","d"," "," "," "," "," "," "," "," "," "," ","x"},
          {"x"," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," ","^","^","^"," "," "," "," "," "," "," ","h","d"," "," "," "," "," "," "," "," "," ","g","x"},
          {"x","i"," ","-","-"," "," "," "," "," "," "," ","i","m","m","m","m","m","m","m","m","m","m","m","m","m","m","m","m","m","m","m","m","m","m","m","m","m","m","x"},
          {"x"," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," ","x"},
          {"x","m"," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," ","x"},
          {"x","m","E"," "," "," "," "," "," "," "," "," "," "," "," "," "," ","m","m"," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," ","x"},
          {"x","m","m","m"," "," "," "," ","E"," "," "," "," ","E"," "," "," ","m","m","m"," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," ","x"},
          {"x","m","m","m","m"," "," ","m","m","m"," "," ","m","m","m","m"," ","m","m","m","m"," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," ","x"},
          {"x"," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," ","m","m","m","m","m"," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," ","x"},
          {"x","^","^","^","^","^","^","^","^","^","^","^","^","^","^","^","^","m","m","m","m","m","m"," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," ","x"},
          {"x","m","m","m","m","m","m","m","m","m","m","m","m","m","m","m","m","m","m","m","m","m","m","m","m","m","m","m","m","m","m","m","m","m"," "," "," "," "," ","x"},
          {"x"," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," ","m"," "," "," "," ","x"},
          {"x"," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," ","m"," "," "," ","x"},
          {"x"," "," "," "," "," "," "," "," "," "," "," ","E"," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," ","m","m"," ","x"},
          {"x"," "," ","-"," ","m","i","-"," "," "," ","i","m","m"," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," ","x"},
          {"x"," "," "," "," ","m"," "," "," "," "," "," ","m","m"," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," ","m","x"},
          {"x"," "," "," "," ","m"," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," ","m","m"," "," "," "," "," "," "," "," "," ","m","m","x"},
          {"x","-"," "," "," ","m"," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," ","m","m","m","m"," "," "," "," "," "," ","m","m","m","m","x"},
          {"x"," "," "," "," ","m","i","-","-"," "," "," "," "," "," "," "," "," ","i","-","-"," "," "," "," "," ","i","-","-"," "," "," "," "," "," "," "," "," ","i","x"},
          {"x"," "," "," "," ","m"," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," ","x"},
          {"x"," "," ","-"," ","m"," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," ","x"},
          {"x"," "," "," "," ","m"," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," ","x"},
          {"x"," "," "," "," ","m","^","^","^","^","^","^","^","^","^","^","^","^","^","^","^","^","^","^","^","^","^","^","^","^","^","^","^","^","^","^","^","^","^","x"},
          {"x","-"," "," "," ","m","m","m","m","m","m","m","m","m","m","m","m","m","m","m","m","m","m","m","m","m","m","m","m","m","m","m","m","m","m","m","m","m","m","x"},
          {"x"," "," ","i"," ","d"," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," ","x"},
          {"x","i","i"," "," ","d"," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," ","x"},
          {"x","m","m"," "," ","d","E","E"," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," ","i"," "," "," "," "," "," "," "," ","x"},
          {"x","m","m","m","m","m","m","m","m","m","m","m","m","m","m","m","m","m","m","m","m","m","m","m","m","m","m","m","m","m","m"," "," ","m","m","m","m","m","m","x"},
          {"x"," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," ","m"," "," "," "," "," "," ","x"},
          {"x","P"," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," ","x"},
          {"x","m","m","m","m","m","m","-"," "," "," "," ","m"," ","-"," "," "," "," "," "," "," "," ","m","m","m","m","m","m","m","m","m","m","m","m","m","m","m","m","x"},
          {"x","^","^","^","^","^","^","^","^","^","^","^","^","^","^","^","^","^","^","^","^","^","^","^","^","^","^","^","^","^","^","^","^","^","^","^","^","^","^","x"},
          {"x","x","x","x","x","x","x","x","x","x","x","x","x","x","x","x","x","x","x","x","x","x","x","x","x","x","x","x","x","x","x","x","x","x","x","x","x","x","x","x"}

        };
    }


    public void addAllObjectsToGameModel(){
        TileCache tileCache = TileCache.getInstance();
        tileCache.loadCache();
        int count = 1;
        for (int i = 0; i< 1600; i++) {
            String stringChar =  map[i/40][i%40];
            switch (stringChar) {
                case "x":
                    clonedTile1 = (Tile) tileCache.getTile("wall1");
                    clonedTile1.setX((i%40) * clonedTile1.getWidth());
                    clonedTile1.setY((i/40) * clonedTile1.getWidth());
                    tileHandler.addTile(clonedTile1);
                    break;
                case " ":
                    break;
                case "m":
                    clonedTile2 = (Tile) tileCache.getTile("wall2");
                    clonedTile2.setX((i%40) * clonedTile2.getWidth());
                    clonedTile2.setY((i/40) * clonedTile2.getWidth());
                    tileHandler.addTile(clonedTile2);
                    break;
                case "^":
                    clonedTile4 = (Trap1) tileCache.getTile("trap1");
                    clonedTile4.setX((i%40) * clonedTile4.getWidth());
                    clonedTile4.setY((i/40) * clonedTile1.getHeight());
                    clonedTile4.setTrapDirection("up");
                    tileHandler.addTile(clonedTile4);
                    break;
                case "i":
                    clonedTile3 = (Tile) tileCache.getTile("invisibleWall");
                    clonedTile3.setX((i%40) * clonedTile3.getWidth());
                    clonedTile3.setY((i/40) * clonedTile3.getHeight());
                    tileHandler.addTile(clonedTile3);
                    break;
//                case 5:
//                    clonedTile2 = (Tile) tileCache.getTile("wall2");
//                    clonedTile2.setX((i%40) * clonedTile2.getWidth());
//                    clonedTile2.setY((i/40) * clonedTile2.getWidth());
//                    tileHandler.addTile(clonedTile2);
//                    break;
                case "-":
                    woodBridge = (WoodBridge) tileCache.getTile("woodBridge");
                    woodBridge.setX((i%40)*woodBridge.getWidth());
                    woodBridge.setY((i/40)* woodBridge.getHeight());
                    tileHandler.addTile(woodBridge);
                    break;
                case "d":
                    clonedTile3 = (Tile) tileCache.getTile("wall3");
                    clonedTile3.setX((i%40) * clonedTile3.getWidth());
                    clonedTile3.setY((i/40) * clonedTile3.getWidth());
                    tileHandler.addTile(clonedTile3);
                    break;
                case "P":
                    player1.setX((i%40)*40);
                    player1.setY((i/40)*40);
                    entityHandler.addEntity(player1);
                    break;
                case "E":
                    aienemy = new AIenemy((i%40) * 40, (i/40) * 40, 40, 40, true, Id.Goomba, entityHandler);
                    entityHandler.addEntity(aienemy);
                    break;
                case "h":
                    aiHouse = new AiHouse((i%40)* 40,(i/40)*40);
                    houseHandler.addHouse(aiHouse);
                    break;

                case "B":
                    finalBoss.setX((i%40) * 40);
                    finalBoss.setY((i/40) * 40);
                    entityHandler.addEntity(finalBoss);
                    break;
                case "F":
                    eagle = new Eagle(40, 40, true, Id.Eagle, entityHandler);
                    eagle.setX((i%40)* 40);
                    eagle.setY((i/40)* 40);
                    entityHandler.addEntity(eagle);
                    break;
                case "FR":
                    eagle = new Eagle(40, 40, true, Id.Eagle, entityHandler);
                    eagle.setX((i%40)* 40);
                    eagle.setY((i/40)* 40);
                    eagle.setFacing(1);
                    entityHandler.addEntity(eagle);
                    break;
                case "g":
                    portal =(Portal) tileCache.getTile("portal");
                    portal.setX((i%40)* 40);
                    portal.setY((i/40)*40);
                    break;
                default:

            }
      }

   }

    public static GameMap getInstance(){
        return gameMap;
    }
    public void emptyMap(){
        entityHandler.emptyHandler();
        tileHandler.emptyHandler();
        houseHandler.emptyHandler();
        itemHandler.removeAllItems();
    }
    public void resetMap(){
        emptyMap();
        player1.healAndRefill();
        this.addAllObjectsToGameModel();
    }
    public void changeMap(){
        entityHandler.emptyHandler();
        tileHandler.emptyHandler();
        houseHandler.emptyHandler();
        itemHandler.removeAllItems();
//        this.getMapData2();
        this.addAllObjectsToGameModel();
    }
    public void addPortal(){
        tileHandler.addTile(portal);
    }
}
