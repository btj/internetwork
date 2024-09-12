package internetwork;

import java.util.HashSet;
import java.util.Set;

import logicalcollections.LogicalSet;

/**
 * @invar | getNetworks().stream().allMatch(n -> n != null && n.getDevices().contains(this))
 */
public class Device {
	
	/**
	 * @invar | networks != null
	 * @invar | networks.stream().allMatch(n -> n != null && n.devices.contains(this))
	 * 
	 * @representationObject
	 * @peerObjects
	 */
	Set<Network> networks = new HashSet<>();
	
	/**
	 * @post | result != null
	 * @creates | result
	 * @peerObjects
	 */
	public Set<Network> getNetworks() {
		return Set.copyOf(networks);
	}
	
	/**
	 * @post | getNetworks().isEmpty()
	 */
	public Device() {}
	
	/**
	 * @throws IllegalArgumentException | network == null
	 * @mutates_properties | getNetworks(), network.getDevices()
	 * @post | getNetworks().equals(LogicalSet.plus(old(getNetworks()), network))
	 * @post | network.getDevices().equals(LogicalSet.plus(old(network.getDevices()), this))
	 */
	public void connectTo(Network network) {
		if (network == null)
			throw new IllegalArgumentException("`network` is null");
		
		networks.add(network);
		network.devices.add(this);
	}
	
	/**
	 * @pre | network != null
	 * @mutates_properties | getNetworks(), network.getDevices()
	 * @post | getNetworks().equals(LogicalSet.minus(old(getNetworks()), network))
	 * @post | network.getDevices().equals(LogicalSet.minus(old(network.getDevices()), this))
	 */
	public void disconnectFrom(Network network) {
		networks.remove(network);
		network.devices.remove(this);
	}

}
