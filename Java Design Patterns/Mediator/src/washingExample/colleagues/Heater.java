package washingExample.colleagues;

import washingExample.MachineMediator;

public class Heater implements Colleague {

    private MachineMediator mediator;

    public void setMediator(MachineMediator mediator) {
        this.mediator = mediator;
    }

    public void on(int temp) {
        System.out.println("Heater on");
        if (mediator.checkTemperature(temp)) {
            System.out.println("Temperature changed to " + temp);
            mediator.off();
        }
    }

    public void off() {
        System.out.println("Heater off");
        mediator.wash();
    }
}
