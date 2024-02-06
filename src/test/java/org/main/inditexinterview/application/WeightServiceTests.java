package org.main.inditexinterview.application;

import org.junit.jupiter.api.Test;
import org.main.inditexinterview.application.interfaces.WeightService;
import org.main.inditexinterview.application.service.DefaultWeightService;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class WeightServiceTests {

    @Test
    public void testGetWeight() {
        WeightService weightService = new DefaultWeightService();
        Map<String, Double> weights = Map.of("salesUnits", 0.8, "stockRatio", 0.2);

        double result = weightService.getWeight("salesUnits", weights);

        assertEquals(0.8, result);
    }

    @Test
    public void testGetWeightDefault() {
        WeightService weightService = new DefaultWeightService();
        Map<String, Double> weights = Map.of("stockRatio", 0.2);

        double result = weightService.getWeight("salesUnits", weights);

        assertEquals(1.0, result);
    }

    @Test
    public void testValidateWeights() {
        WeightService weightService = new DefaultWeightService();
        Map<String, Double> weights = Map.of("salesUnits", 0.8, "stockRatio", 0.2);

        assertThrows(IllegalArgumentException.class, () -> weightService.validateWeights(weights));
    }
}
