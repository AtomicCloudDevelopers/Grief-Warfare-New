package net.dynamicjk.game.api;

import org.bukkit.entity.Player;
import org.bukkit.entity.TNTPrimed;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class PlayerPlaceTNTEvent extends Event {

    Player p;
    
    TNTPrimed t;	
   
    public PlayerPlaceTNTEvent(Player p, TNTPrimed t) {
            this.p = p;
            this.t = t;
    }
   
    public Player getPlayer() {
            return p;
    }
    
    public TNTPrimed getPlacedTNT(){
    	return t;
    }
   
    private static final HandlerList handlers = new HandlerList();
     
    public HandlerList getHandlers() {
        return handlers;
    }
     
    public static HandlerList getHandlerList() {
        return handlers;
    }
}