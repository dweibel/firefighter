package main.firefighters;

import main.api.Building;
import main.api.CityNode;
import main.api.Firefighter;
import main.api.exceptions.NoFireFoundException;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class FirefighterImpl implements Firefighter {

  public FirefighterImpl(CityNode location) {
    this.location = location;
  }

  private CityNode location;
  int distanceTraveled = 0;

  @Override
  public CityNode getLocation() {
    return location;
  }

  @Override
  public int distanceTraveled() {
    return distanceTraveled;
  }

  @Override
  public void extinguishFire(Building building) {
    CityNode node = building.getLocation();
    distanceTraveled += calculateDistance(node);
    location = node;
    try {
      building.extinguishFire();
    } catch (NoFireFoundException e) {
      e.printStackTrace();
    }
  }

  @Override
  public int calculateDistance(CityNode node) {
    int xDistance = node.getX() - location.getX();
    int yDistance = node.getY() - location.getY();
    return Math.abs(xDistance) + Math.abs(yDistance);
//    return (int) Math.round(Math.sqrt((yDistance) * (yDistance) + (xDistance) * (xDistance)));
  }
}
