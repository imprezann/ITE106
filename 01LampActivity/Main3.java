class Main3 {
	public static void main (String[] args) {

		Lamp led = new Lamp();
		Lamp halogen = new Lamp();
		Lamp fluorescent = new Lamp() ;
		Lamp incandescent = new Lamp();

		led.name = args [0];
		halogen.name = args [2];
		fluorescent.name = args [0];
		incandescent.name = args [2];

		led.isOn = Boolean.parseBoolean (args[1]);
		led.turnOn();

		fluorescent.isOn = Boolean.parseBoolean (args[1]);
		fluorescent.turnOn();

		halogen.isOn = Boolean.parseBoolean (args[3]);
		halogen.turnOff();

		incandescent.isOn = Boolean.parseBoolean(args[3]);
		incandescent.turnOff();
	}
}
