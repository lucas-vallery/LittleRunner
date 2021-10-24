public class Hero extends AnimatedThings{

    public Hero (String fileName, double x, double y) {
        super(fileName, x, y);
        this.setxWindow(720);
        this.setyWindow(490);
        this.getImage().setPreserveRatio(true);
        this.getImage().setFitHeight(heroHeight);
    }

    public int getHeroHeight () {return heroHeight;}

    private int heroHeight = 150;
}
