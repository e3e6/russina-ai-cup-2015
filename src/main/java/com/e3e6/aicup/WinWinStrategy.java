package com.e3e6.aicup;

import model.Car;
import model.Game;
import model.Move;
import model.World;

public final class WinWinStrategy implements Strategy {
	int sign = 1;
	
    @Override
    public void move(Car self, World world, Game game, Move move) {
        move.setEnginePower(1.0D);
//        move.setThrowProjectile(true);
//        move.setSpillOil(true);   
        
        




        if (world.getTick() > game.getInitialFreezeDurationTicks()) {
//            move.setUseNitro(true);
        	double wheel = self.getWheelTurn() ;

        	if(wheel > 0 && wheel >= 1){
        		sign = -1;
        	} else if(wheel < 0 && wheel <= -1){
        		sign = 1;
        	}
        	move.setWheelTurn(self.getWheelTurn() + 0.1*sign);
        }
        
        log(world, "Move.Wheel: " + move.getWheelTurn());
        log(world, "Car.Wheel: " + self.getWheelTurn());
        log(world, "--") ;
    }
    

    private void log(World world, String text){
    	if(world != null)
    		System.out.println(world.getTick() + ": " + text);
    	else 
    		System.out.println(text);
    }
}
