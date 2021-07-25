package main.api;

public interface Firefighter {

  /**
   * Get the firefighter's current location. Initially, the firefighter should be at the FireStation
   *
   * @return {@link CityNode} representing the firefighter's current location
   */
  CityNode getLocation();

  /**
   * Get the total distance traveled by this firefighter. Distances should be represented using TaxiCab
   * Geometry: https://en.wikipedia.org/wiki/Taxicab_geometry
   *
   * @return the total distance traveled by this firefighter
   */
  int distanceTraveled();

  /**
   * Move to a burning building and extinguish it.
   * @param building {@link Building} representing the burning building
   */
  void extinguishFire(Building building);

  /**
   * Calculate the distance to a specific location
   * @param node {@link CityNode} representing the firefighter's new location
   * @return the travel distance required by this firefighter
   */
  int calculateDistance(CityNode node);
}
