package internetwork.tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Set;

import org.junit.jupiter.api.Test;

import internetwork.Device;
import internetwork.Network;

class InternetworkTest {

	Device pc = new Device();
	Network wifi = new Network();
	
	@Test
	void testDeviceConstructor() {
		assertEquals(Set.of(), pc.getNetworks());
	}
	
	@Test
	void testNetworkConstructor() {
		assertEquals(Set.of(), wifi.getDevices());
	}
	
	@Test
	void testConnectTo() {
		pc.connectTo(wifi);
		assertEquals(Set.of(wifi), pc.getNetworks());
		assertEquals(Set.of(pc), wifi.getDevices());
	}
	
	@Test
	void testDisconnectFrom() {
		pc.connectTo(wifi);
		pc.disconnectFrom(wifi);
		assertEquals(Set.of(), pc.getNetworks());
		assertEquals(Set.of(), wifi.getDevices());
	}

}
