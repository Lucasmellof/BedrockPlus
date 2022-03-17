package net.anvian.bedrockplus.world.feature;

import net.anvian.bedrockplus.BedrockPlusMod;
import net.anvian.bedrockplus.block.ModBlocks;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.decorator.RangeDecoratorConfig;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.heightprovider.UniformHeightProvider;

public class ModConfiguredFeatures {
    public static  final RegistryKey<ConfiguredFeature<?,?>> IMPURE_BEDROCK_KEY =
            registerKey("impure_bedrock_ore");

    public static final ConfiguredFeature<?, ?> IMPURE_BEDROCK_ORE = register(Feature.ORE.configure(
                    new OreFeatureConfig(OreFeatureConfig.Rules.BASE_STONE_OVERWORLD, ModBlocks.IMPURE_BEDROCK.getDefaultState(), 5))//vein size
            .range(new RangeDecoratorConfig(UniformHeightProvider.create(YOffset.getBottom(), YOffset.fixed(5))))
            .spreadHorizontally().repeat(55), IMPURE_BEDROCK_KEY);// veins per chunk

    private static RegistryKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return RegistryKey.of(Registry.CONFIGURED_FEATURE_KEY, new Identifier(BedrockPlusMod.MOD_ID, name));
    }

    private static ConfiguredFeature<?, ?> register(ConfiguredFeature<?, ?> configuredFeature,
                                                    RegistryKey<ConfiguredFeature<?, ?>> key) {
        return Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, key.getValue(), configuredFeature);
    }

    public static void registerConfiguredFeatures() {
        System.out.println("Registering ModConfiguredFeatures for " + BedrockPlusMod.MOD_ID);
    }
}
