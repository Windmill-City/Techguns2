package techguns.server;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.relauncher.Side;
import techguns.CommonProxy;
import techguns.events.TechgunsGuiHandler.GuiHandlerRegister;
import techguns.gui.containers.AmmoPressContainer;
import techguns.gui.containers.CamoBenchContainer;
import techguns.gui.containers.ChargingStationContainer;
import techguns.gui.containers.ChemLabContainer;
import techguns.gui.containers.Door3x3Container;
import techguns.gui.containers.DungeonGeneratorContainer;
import techguns.gui.containers.DungeonScannerContainer;
import techguns.gui.containers.FabricatorContainer;
import techguns.gui.containers.MetalPressContainer;
import techguns.gui.containers.ReactionChamberContainer;
import techguns.gui.containers.RepairBenchContainer;
import techguns.gui.containers.TurretContainer;
import techguns.tileentities.AmmoPressTileEnt;
import techguns.tileentities.CamoBenchTileEnt;
import techguns.tileentities.ChargingStationTileEnt;
import techguns.tileentities.ChemLabTileEnt;
import techguns.tileentities.Door3x3TileEntity;
import techguns.tileentities.DungeonGeneratorTileEnt;
import techguns.tileentities.DungeonScannerTileEnt;
import techguns.tileentities.FabricatorTileEntMaster;
import techguns.tileentities.MetalPressTileEnt;
import techguns.tileentities.ReactionChamberTileEntMaster;
import techguns.tileentities.RepairBenchTileEnt;
import techguns.tileentities.TurretTileEnt;

@Mod.EventBusSubscriber(Side.SERVER)
public class ServerProxy extends CommonProxy {

	protected GuiHandlerRegister guihandler = new GuiHandlerRegister();
	
	@Override
	public void preInit(FMLPreInitializationEvent event) {
		super.preInit(event);
	}

	@Override
	public void init(FMLInitializationEvent event) {
		super.init(event);
		guihandler.<CamoBenchTileEnt>addEntry(CamoBenchTileEnt.class, CamoBenchContainer::new);
		guihandler.<RepairBenchTileEnt>addEntry(RepairBenchTileEnt.class, RepairBenchContainer::new);
		guihandler.<AmmoPressTileEnt>addEntry(AmmoPressTileEnt.class, AmmoPressContainer::new);
		guihandler.<MetalPressTileEnt>addEntry(MetalPressTileEnt.class, MetalPressContainer::new);
		guihandler.<ChemLabTileEnt>addEntry(ChemLabTileEnt.class, ChemLabContainer::new);
		guihandler.<TurretTileEnt>addEntry(TurretTileEnt.class, TurretContainer::new);
		guihandler.<FabricatorTileEntMaster>addEntry(FabricatorTileEntMaster.class, FabricatorContainer::new);
		guihandler.<ChargingStationTileEnt>addEntry(ChargingStationTileEnt.class, ChargingStationContainer::new);
		guihandler.<ReactionChamberTileEntMaster>addEntry(ReactionChamberTileEntMaster.class, ReactionChamberContainer::new);
		guihandler.<DungeonScannerTileEnt>addEntry(DungeonScannerTileEnt.class, DungeonScannerContainer::new);
		guihandler.<DungeonGeneratorTileEnt>addEntry(DungeonGeneratorTileEnt.class, DungeonGeneratorContainer::new);
		guihandler.<Door3x3TileEntity>addEntry(Door3x3TileEntity.class, Door3x3Container::new);
	}
	
	@Override
	public GuiHandlerRegister getGuihandlers() {
		return guihandler;
	}

	@Override
	public void postInit(FMLPostInitializationEvent event) {
		super.postInit(event);
	}

	
	
}
