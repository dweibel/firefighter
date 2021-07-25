package main.firefighters;

import java.util.*;

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
    for(CityNode burnLocation: burningBuildings) {
      Firefighter fighter = getClosestFirefighter(burnLocation);
      Building building = city.getBuilding(burnLocation);
      fighter.extinguishFire(building);
    }
  }

  private Firefighter getClosestFirefighter(CityNode burnLocation) {
    FighterDistance[] distances = new FighterDistance[firefighters.size()];
    for (int x = 0; x < distances.length; x++) {
      distances[x] = new FighterDistance(firefighters.get(x), burnLocation);
    }
    return Arrays.stream(distances).min(new SortDistance()).get().firefighter;
  }

  class FighterDistance {
    FighterDistance(Firefighter firefighter, CityNode location) {
      this.firefighter = firefighter;
      distance = firefighter.calculateDistance(location);
    }

    Firefighter firefighter;
    int distance;
  }

  static class SortDistance implements Comparator<FighterDistance>{
    @Override
    public int compare(FighterDistance fd1, FighterDistance fd2) {
      return fd1.distance - fd2.distance;
    }
  }
}
