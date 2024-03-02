interface IPlayable {
    public void start(String a);

    public void stop(String b);

    public void pause(String c);

    public void unpause(String d);
}

abstract class MusicPlayer implements IPlayable{
    public void start(String a){
        System.out.println("I'm playing");
    }

    public void stop(String b){
        System.out.println("I'm stopping");
    }

    public abstract void pause(String c);

    public abstract void unpause(String d);
}

class PortableMusicPlayer extends MusicPlayer{
    public void pause(String c){
        System.out.println("I'm Pausing");
    }
    public void unpause(String d){
        System.out.println("I'm unpausing");
    }
}

class main{
    public static void main(String[] args){
        PortableMusicPlayer one = new PortableMusicPlayer();
        PortableMusicPlayer two = new PortableMusicPlayer();
    }
}