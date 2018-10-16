/**
 * 
 */

import java.util.List;

/**
 * @author daniel.shamaeli
 *
 */
public interface AreaRepository {

	/**
	 * gives a list of all Areas
	 * 
	 * @return a list of all Areas
	 */
	public List<Area> getAllAreas();

	/**
	 * gives a list of only Active Areas
	 * 
	 * @return a list of only Active Areas
	 */
	public List<Area> getActiveAreas();

}
