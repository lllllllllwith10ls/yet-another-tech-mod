package lllllllll.yatm.core;

import java.util.HashMap;

import lllllllll.yatm.YetAnotherTechMod;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.fmllegacy.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ItemInit {
	public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, YetAnotherTechMod.MOD_ID);
	

	public static final HashMap<String,RegistryObject<Item>> ITEM_MAP = new HashMap<>();

	public static final RegistryObject<Item> MASCOT = ITEMS.register("mascot",
			() -> new BlockItem(BlockInit.MASCOT.get(),
					new Item.Properties().tab(YetAnotherTechMod.MAIN_GROUP)));

	public static void registerResources()
	{
		for(int i = 0; i < Resource.values().length; i++)
		{

			if(Resource.values()[i].hasRaw)
			{
				ITEM_MAP.put("raw_" + Resource.values()[i].name, ITEMS.register("raw_" + Resource.values()[i].name,
						() -> new Item(new Item.Properties().tab(YetAnotherTechMod.MAIN_GROUP))));
			}
		}
	}
}
