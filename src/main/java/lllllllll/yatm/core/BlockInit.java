package lllllllll.yatm.core;

import java.util.HashMap;

import lllllllll.yatm.YetAnotherTechMod;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraftforge.fmllegacy.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class BlockInit {
	public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, YetAnotherTechMod.MOD_ID);

	public static final RegistryObject<Block> MASCOT = BLOCKS
			.register("mascot",
					() -> new Block(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.COLOR_LIGHT_GRAY)
							.strength(15f, 30f).sound(SoundType.STONE)));

	public static final HashMap<String,RegistryObject<Block>> BLOCK_MAP = new HashMap<>();
	
	public static void registerResources()
	{
		for(int i = 0; i < Resource.values().length; i++)
		{
			if(Resource.values()[i].hasOre)
			{
				BLOCK_MAP.put(Resource.values()[i].name + "_ore",
						BLOCKS.register(Resource.values()[i].name + "_ore",
						() -> new Block(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.COLOR_LIGHT_GRAY)
								.strength(3f, 3f).sound(SoundType.STONE))));
				RegistryObject<Block> ore = BLOCK_MAP.get(Resource.values()[i].name + "_ore");
				BLOCK_MAP.put("deepslate_" + Resource.values()[i].name + "_ore",
						BLOCKS.register("deepslate_" + Resource.values()[i].name + "_ore",
						() -> new Block(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.COLOR_LIGHT_GRAY)
								.strength(3f, 4.5f).sound(SoundType.DEEPSLATE))));
				RegistryObject<Block> deepslateOre = BLOCK_MAP.get("deepslate_" + Resource.values()[i].name + "_ore");

				ItemInit.ITEM_MAP.put(Resource.values()[i].name + "_ore", 
						ItemInit.ITEMS.register(Resource.values()[i].name + "_ore",
						() -> new BlockItem(ore.get()
								,new Item.Properties().tab(YetAnotherTechMod.MAIN_GROUP))));
				ItemInit.ITEM_MAP.put("deepslate_" + Resource.values()[i].name + "_ore", 
						ItemInit.ITEMS.register("deepslate_" + Resource.values()[i].name + "_ore",
						() -> new BlockItem(deepslateOre.get()
								,new Item.Properties().tab(YetAnotherTechMod.MAIN_GROUP))));
			}
		}
	}
}
