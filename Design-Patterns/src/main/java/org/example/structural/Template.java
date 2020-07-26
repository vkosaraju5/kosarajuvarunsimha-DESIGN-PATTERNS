package org.example.structural;

abstract class Game{
    abstract void initialize();
    abstract void start();
    abstract void end();

    public final void play(){
        initialize();
        start();
        end();
    }
}

class Chess extends Game{
    @Override
    void initialize(){
        System.out.println("Chess is Initialized");
    }
    @Override
    void start(){
        System.out.println("Chess is Started");
    }
    @Override
    void end(){
        System.out.println("Chess is Finished");
    }

}


class BasketBall extends Game{
    @Override
    void initialize(){
        System.out.println("BasketBall is Initialized");
    }
    @Override
    void start(){
        System.out.println("BasketBall is Started");
    }
    @Override
    void end(){
        System.out.println("BasketBall is Finished");
    }

}


public class Template{
    public static void main(String[] args) throws InstantiationException,IllegalAccessException,ClassNotFoundException {
        Class c = Class.forName("org.example.structural.Chess");
        Game game = (Game)c.newInstance();
        game.play();

    }
}
