package internetwork;

import java.util.HashSet;
import java.util.Set;

/**
 * @invar | getDevices().stream().allMatch(d -> d != null && d.getNetworks().contains(this))
 */
public class Network {
	
	/**
	 * @invar | devices != null
	 * @invar | devices.stream().allMatch(d -> d != null && d.networks.contains(this))
	 * 
	 * @representationObject
	 * @peerObjects
	 */
	Set<Device> devices = new HashSet<>();

	/**
	 * @post | result != null
	 * @creates | result
	 * @peerObjects
	 */
	public Set<Device> getDevices() {
		return Set.copyOf(devices);
	}
	
	/**
	 * @post | getDevices().isEmpty()
	 */
	public Network() {}
	
}
