package lllllllll.yatm;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import lllllllll.yatm.core.BlockInit;
import lllllllll.yatm.core.ItemInit;


// The value here should match an entry in the META-INF/mods.toml file
@Mod("yetanothertechmod")
public class YetAnotherTechMod
{
    // Directly reference a log4j logger.
    public static final Logger LOGGER = LogManager.getLogger();
    public static String MOD_ID = "yetanothertechmod"; 
	public static final CreativeModeTab MAIN_GROUP = new MainGroup("yatmtab");
    
    public YetAnotherTechMod() {
    	BlockInit.registerResources();
    	ItemInit.registerResources();
		IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
		bus.addListener(this::setup);

		ItemInit.ITEMS.register(bus);
		BlockInit.BLOCKS.register(bus);
    }

    private void setup(final FMLCommonSetupEvent event)
    {
    	
    }
    public static class MainGroup extends CreativeModeTab {

		public MainGroup(String label) {
			super(label);
		}

		@Override
		public ItemStack makeIcon() {
			return ItemInit.MASCOT.get().getDefaultInstance();
		}
	}
}
