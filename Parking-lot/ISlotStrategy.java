import java.util.List;

public interface ISlotStrategy {
    Slot findSlot(Vehicle v, EntryGate gate, List<level> levels);
}
