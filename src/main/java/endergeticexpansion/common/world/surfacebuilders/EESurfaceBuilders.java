package endergeticexpansion.common.world.surfacebuilders;

import java.util.function.Supplier;

import endergeticexpansion.core.EndergeticExpansion;
import endergeticexpansion.core.registry.EEBlocks;
import net.minecraft.block.Blocks;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class EESurfaceBuilders {
	public static final DeferredRegister<SurfaceBuilder<?>> SURFACE_BUILDERS = new DeferredRegister<>(ForgeRegistries.SURFACE_BUILDERS, EndergeticExpansion.MOD_ID);
	
	public static final Supplier<SurfaceBuilderConfig> END_STONE_CONFIG = () -> new SurfaceBuilderConfig(Blocks.END_STONE.getDefaultState(), Blocks.END_STONE.getDefaultState(), Blocks.END_STONE.getDefaultState());
	public static final Supplier<SurfaceBuilderConfig> EUMUS_CONFIG     = () -> new SurfaceBuilderConfig(EEBlocks.EUMUS.get().getDefaultState(), EEBlocks.EUMUS.get().getDefaultState(), EEBlocks.EUMUS.get().getDefaultState());
	public static final Supplier<SurfaceBuilderConfig> POISMOSS_CONFIG  = () -> new SurfaceBuilderConfig(EEBlocks.POISMOSS.get().getDefaultState(), Blocks.END_STONE.getDefaultState(), EEBlocks.EUMUS.get().getDefaultState());
	public static final Supplier<SurfaceBuilderConfig> CORROCK_CONFIG   = () -> new SurfaceBuilderConfig(EEBlocks.CORROCK_END_BLOCK.get().getDefaultState(), EEBlocks.EUMUS.get().getDefaultState(), EEBlocks.PETRIFIED_CORROCK_END_BLOCK.get().getDefaultState());
	
	public static final RegistryObject<SurfaceBuilder<SurfaceBuilderConfig>> POISE_SURFACE_BUILDER          = createSurfaceBuilder("poise_forest", () -> new SurfaceBuilderPoiseForest(SurfaceBuilderConfig::deserialize));
	public static final RegistryObject<SurfaceBuilder<SurfaceBuilderConfig>> SPARSE_CORROCK_SURFACE_BUILDER = createSurfaceBuilder("sparse_corrock", () -> new SurfaceBuilderSparseCorrock(SurfaceBuilderConfig::deserialize));
	
	private static <S extends SurfaceBuilder<?>> RegistryObject<S> createSurfaceBuilder(String name, Supplier<S> sup) {
		return SURFACE_BUILDERS.register(name, sup);
	}
}