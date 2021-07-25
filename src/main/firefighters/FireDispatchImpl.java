package main.firefighters;

import java.util.ArrayList;
import java.util.List;

import main.api.*;

public class FireDispatchImpl implements FireDispatch {


  private List<Firefighter> firefighters =  new ArrayList<Firefighter>();
  private City city;

  public FireDispatchImpl(City city) {
    this.city = city;
  }

  @Override
  public void setFirefighters(int numFirefighters) {
    // TODO firefighters need to be spread across the city;
    for (int x = 0; x < numFirefighters; x++) {
      firefighters.add(new FirefighterImpl(city.getFireStation().getLocation()));
    }
  }

  @Override
  public List<Firefighter> getFirefighters() {
    return firefighters;
  }

  @Override
  public void dispatchFirefighers(CityNode... burningBuildings) {
    if (firefighters.size() < burningBuildings.length) {
      throw new RuntimeException("Too much carnage");
    }
    for(CityNode burnLocation: burningBuildings) {
      Firefighter fighter = getClosestFirefighter(burnLocation);
      Building building = city.getBuilding(burnLocation);
      fighter.extinguishFire(building);
    }
  }

  private Firefighter getClosestFirefighter(CityNode burnLocation) {
    // TODO correctly implement
    return firefighters.get(0);
  }

}
