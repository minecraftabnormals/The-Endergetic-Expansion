package endergeticexpansion.common.world;

import com.google.common.collect.ImmutableList;

import endergeticexpansion.api.generation.IAddToBiomes;
import endergeticexpansion.common.world.features.EEFeatures;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.biome.Biomes;
import net.minecraft.world.gen.GenerationStage.Decoration;
import net.minecraft.world.gen.feature.EndSpikeFeatureConfig;
import net.minecraft.world.gen.placement.IPlacementConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraftforge.registries.ForgeRegistries;

public final class EEWorldGenHandler {
	public static void addFeaturesToVanillaBiomes() {
		EEFeatures.FEATURES.getEntries().stream().filter(feature -> (feature.get() instanceof IAddToBiomes)).forEach((feature) -> {
			ForgeRegistries.BIOMES.forEach(((IAddToBiomes) feature.get()).processBiomeAddition());
		});
	}

	public static void overrideFeatures() {
		Biomes.THE_END.getFeatures(Decoration.SURFACE_STRUCTURES).set(0, EEFeatures.ENDERGETIC_END_SPIKE.get().withConfiguration(new EndSpikeFeatureConfig(false, ImmutableList.of(), (BlockPos)null)).withPlacement(Placement.NOPE.configure(IPlacementConfig.NO_PLACEMENT_CONFIG)));
	}
}