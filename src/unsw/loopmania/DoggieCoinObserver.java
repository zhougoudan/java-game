package unsw.loopmania;

public interface DoggieCoinObserver {
    /**
	 * register observer
	 * @param ob
	 */
    void registerObserver(Observer ob);
	/**
	 * remove observer
	 * @param ob
	 */
	void removeObserver(Observer ob);
	/**
	 * notify observer
	 */
	void notifyObservers(int newPrice);
}
