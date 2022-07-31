package functional.principles;

@FunctionalInterface
interface Operation {
    int applyOperation(int number);

    default int another(int number) {
        return 0;
    }
}
