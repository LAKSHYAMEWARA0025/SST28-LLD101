public class ClassroomController {
    private final DeviceRegistry reg;

    public ClassroomController(DeviceRegistry reg) { this.reg = reg; }

    public void startClass() {
        Projection pj = reg.getByCapability(Projection.class);
        Power pjPower=reg.getByCapability(Power.class);
        pjPower.powerOn();
        pj.connectInput("HDMI-1");

        BrightnessController lights = reg.getByCapability(BrightnessController.class);
        lights.setBrightness(60);

        TemperaturController ac = reg.getByCapability(TemperaturController.class);
        ac.setTemperatureC(24);

        Attendance scan = reg.getByCapability(Attendance.class);
        System.out.println("Attendance scanned: present=" + scan.scanAttendance());
    }

    public void endClass() {
        System.out.println("Shutdown sequence:");
        reg.getByCapability(Projector.class).powerOff();
        reg.getByCapability(LightsPanel.class).powerOff();
        reg.getByCapability(AirConditioner.class).powerOff();
    }
}
