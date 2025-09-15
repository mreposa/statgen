package org.mreposa.statgen.generator;

public interface StatGenerator {
    int[] generate(String selectedClass, String selectedRace, String selectedMethod);
}
