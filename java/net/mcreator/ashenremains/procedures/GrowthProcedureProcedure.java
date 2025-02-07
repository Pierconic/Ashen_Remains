package net.mcreator.ashenremains.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureTemplate;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructurePlaceSettings;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.tags.TagKey;
import net.minecraft.tags.BlockTags;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import net.mcreator.ashenremains.init.AshenremainsModBlocks;

public class GrowthProcedureProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		boolean found = false;
		double Plantnumber = 0;
		double sx = 0;
		double sy = 0;
		double sz = 0;
		double SecondaryPlantNumber = 0;
		if (world instanceof ServerLevel _level)
			_level.sendParticles(ParticleTypes.COMPOSTER, (x + 0.5), (y + 0.5), (z + 0.5), 15, 0.3, 0.3, 0.3, 0.3);
		Plantnumber = Mth.nextInt(RandomSource.create(), 0, 8);
		SecondaryPlantNumber = Mth.nextInt(RandomSource.create(), 0, 3);
		found = false;
		sx = -4;
		for (int index0 = 0; index0 < 8; index0++) {
			sy = -4;
			for (int index1 = 0; index1 < 8; index1++) {
				sz = -4;
				for (int index2 = 0; index2 < 8; index2++) {
					if ((world.getBlockState(BlockPos.containing(x + sx, y + sy, z + sz))).is(BlockTags.create(ResourceLocation.parse("minecraft:leaves")))
							|| (world.getBlockState(BlockPos.containing(x + sx, y + sy, z + sz))).is(BlockTags.create(ResourceLocation.parse("forge:saplings")))) {
						found = true;
					} else if (Plantnumber < 8 && Math.random() < 0.3 && (world.getBlockState(BlockPos.containing(x + sx, y + sy, z + sz))).is(BlockTags.create(ResourceLocation.parse("minecraft:flowers")))) {
						Plantnumber = Plantnumber + 1;
					}
					sz = sz + 1;
				}
				sy = sy + 1;
			}
			sx = sx + 1;
		}
		if (world.canSeeSkyFromBelowWater(BlockPos.containing(x, y + 2, z))) {
			if (world.getBiome(BlockPos.containing(x, y, z)).is(ResourceLocation.parse("forest")) || world.getBiome(BlockPos.containing(x, y, z)).is(ResourceLocation.parse("plains"))) {
				if (Plantnumber == 0) {
					world.setBlock(BlockPos.containing(x, y, z), Blocks.SHORT_GRASS.defaultBlockState(), 3);
				} else if (Plantnumber == 1) {
					if (world instanceof ServerLevel _serverworld) {
						StructureTemplate template = _serverworld.getStructureManager().getOrCreate(ResourceLocation.fromNamespaceAndPath("ashenremains", "tall_grass"));
						if (template != null) {
							template.placeInWorld(_serverworld, BlockPos.containing(x, y, z), BlockPos.containing(x, y, z), new StructurePlaceSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setIgnoreEntities(false), _serverworld.random,
									3);
						}
					}
				} else if (Plantnumber == 2 && found == false) {
					world.setBlock(BlockPos.containing(x, y, z), AshenremainsModBlocks.OAK_SPROUT.get().defaultBlockState(), 3);
				} else if (Plantnumber == 3) {
					world.setBlock(BlockPos.containing(x, y, z), Blocks.SHORT_GRASS.defaultBlockState(), 3);
				} else if (Plantnumber == 4 && found == false) {
					world.setBlock(BlockPos.containing(x, y, z), AshenremainsModBlocks.OAK_SPROUT.get().defaultBlockState(), 3);
				} else if (Plantnumber == 5 && found == false) {
					world.setBlock(BlockPos.containing(x, y, z), AshenremainsModBlocks.OAK_SPROUT.get().defaultBlockState(), 3);
				} else if (Plantnumber == 6 && found == false) {
					world.setBlock(BlockPos.containing(x, y, z), AshenremainsModBlocks.BIRCH_SPROUT.get().defaultBlockState(), 3);
				} else if (Plantnumber == 7) {
					world.setBlock(BlockPos.containing(x, y, z), Blocks.SHORT_GRASS.defaultBlockState(), 3);
				} else if (Plantnumber == 8) {
					if (SecondaryPlantNumber == 0 && found == false) {
						world.setBlock(BlockPos.containing(x, y, z), AshenremainsModBlocks.OAK_SPROUT.get().defaultBlockState(), 3);
					} else if (SecondaryPlantNumber == 1) {
						world.setBlock(BlockPos.containing(x, y, z), Blocks.POPPY.defaultBlockState(), 3);
					} else if (SecondaryPlantNumber == 2 && found == false) {
						world.setBlock(BlockPos.containing(x, y, z), AshenremainsModBlocks.BIRCH_SPROUT.get().defaultBlockState(), 3);
					} else if (SecondaryPlantNumber == 3) {
						world.setBlock(BlockPos.containing(x, y, z), Blocks.DANDELION.defaultBlockState(), 3);
					}
				}
			} else if (world.getBiome(BlockPos.containing(x, y, z)).is(ResourceLocation.parse("birch_forest")) || world.getBiome(BlockPos.containing(x, y, z)).is(ResourceLocation.parse("plains"))
					|| world.getBiome(BlockPos.containing(x, y, z)).is(ResourceLocation.parse("old_growth_birch_forest")) || world.getBiome(BlockPos.containing(x, y, z)).is(ResourceLocation.parse("plains"))) {
				if (Plantnumber == 0) {
					world.setBlock(BlockPos.containing(x, y, z), Blocks.SHORT_GRASS.defaultBlockState(), 3);
				} else if (Plantnumber == 1) {
					world.setBlock(BlockPos.containing(x, y, z), Blocks.SHORT_GRASS.defaultBlockState(), 3);
				} else if (Plantnumber == 2) {
					if (world instanceof ServerLevel _serverworld) {
						StructureTemplate template = _serverworld.getStructureManager().getOrCreate(ResourceLocation.fromNamespaceAndPath("ashenremains", "tall_grass"));
						if (template != null) {
							template.placeInWorld(_serverworld, BlockPos.containing(x, y, z), BlockPos.containing(x, y, z), new StructurePlaceSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setIgnoreEntities(false), _serverworld.random,
									3);
						}
					}
				} else if (Plantnumber == 3) {
					world.setBlock(BlockPos.containing(x, y, z), Blocks.SHORT_GRASS.defaultBlockState(), 3);
				} else if (Plantnumber == 4 && found == false) {
					world.setBlock(BlockPos.containing(x, y, z), AshenremainsModBlocks.BIRCH_SPROUT.get().defaultBlockState(), 3);
				} else if (Plantnumber == 5 && found == false) {
					world.setBlock(BlockPos.containing(x, y, z), AshenremainsModBlocks.BIRCH_SPROUT.get().defaultBlockState(), 3);
				} else if (Plantnumber == 6 && found == false) {
					world.setBlock(BlockPos.containing(x, y, z), AshenremainsModBlocks.BIRCH_SPROUT.get().defaultBlockState(), 3);
				} else if (Plantnumber == 7) {
					world.setBlock(BlockPos.containing(x, y, z), Blocks.SHORT_GRASS.defaultBlockState(), 3);
				} else if (Plantnumber == 8) {
					if (SecondaryPlantNumber == 0) {
						world.setBlock(BlockPos.containing(x, y, z), Blocks.ALLIUM.defaultBlockState(), 3);
					} else if (SecondaryPlantNumber == 1 && found == false) {
						world.setBlock(BlockPos.containing(x, y, z), AshenremainsModBlocks.BIRCH_SPROUT.get().defaultBlockState(), 3);
					} else if (SecondaryPlantNumber == 2) {
						world.setBlock(BlockPos.containing(x, y, z), Blocks.OXEYE_DAISY.defaultBlockState(), 3);
					} else if (SecondaryPlantNumber == 3) {
						world.setBlock(BlockPos.containing(x, y, z), Blocks.AZURE_BLUET.defaultBlockState(), 3);
					}
				}
			} else if (world.getBiome(BlockPos.containing(x, y, z)).is(ResourceLocation.parse("dark_forest")) || world.getBiome(BlockPos.containing(x, y, z)).is(ResourceLocation.parse("plains"))) {
				if (Plantnumber == 0) {
					world.setBlock(BlockPos.containing(x, y, z), Blocks.SHORT_GRASS.defaultBlockState(), 3);
				} else if (Plantnumber == 1) {
					world.setBlock(BlockPos.containing(x, y, z), Blocks.SHORT_GRASS.defaultBlockState(), 3);
				} else if (Plantnumber == 2) {
					world.setBlock(BlockPos.containing(x, y, z), Blocks.SHORT_GRASS.defaultBlockState(), 3);
				} else if (Plantnumber == 3) {
					world.setBlock(BlockPos.containing(x, y, z), AshenremainsModBlocks.DARK_OAK_SPROUT.get().defaultBlockState(), 3);
				} else if (Plantnumber == 4) {
					world.setBlock(BlockPos.containing(x, y, z), Blocks.FERN.defaultBlockState(), 3);
				} else if (Plantnumber == 5) {
					world.setBlock(BlockPos.containing(x, y, z), AshenremainsModBlocks.DARK_OAK_SPROUT.get().defaultBlockState(), 3);
				} else if (Plantnumber == 6) {
					world.setBlock(BlockPos.containing(x, y, z), Blocks.FERN.defaultBlockState(), 3);
				} else if (Plantnumber == 7) {
					world.setBlock(BlockPos.containing(x, y, z), AshenremainsModBlocks.DARK_OAK_SPROUT.get().defaultBlockState(), 3);
				} else if (Plantnumber == 8) {
					world.setBlock(BlockPos.containing(x, y, z), AshenremainsModBlocks.DARK_OAK_SPROUT.get().defaultBlockState(), 3);
				}
			} else if (world.getBiome(BlockPos.containing(x, y, z)).is(ResourceLocation.parse("windswept_forest")) || world.getBiome(BlockPos.containing(x, y, z)).is(ResourceLocation.parse("windswept_gravelly_hills"))
					|| world.getBiome(BlockPos.containing(x, y, z)).is(ResourceLocation.parse("windswept_hills"))) {
				if (Plantnumber == 0) {
					world.setBlock(BlockPos.containing(x, y, z), Blocks.SHORT_GRASS.defaultBlockState(), 3);
				} else if (Plantnumber == 1) {
					world.setBlock(BlockPos.containing(x, y, z), Blocks.SHORT_GRASS.defaultBlockState(), 3);
				} else if (Plantnumber == 2) {
					world.setBlock(BlockPos.containing(x, y, z), Blocks.FERN.defaultBlockState(), 3);
				} else if (Plantnumber == 3) {
					world.setBlock(BlockPos.containing(x, y, z), Blocks.SHORT_GRASS.defaultBlockState(), 3);
				} else if (Plantnumber == 4) {
					world.setBlock(BlockPos.containing(x, y, z), Blocks.SHORT_GRASS.defaultBlockState(), 3);
				} else if (Plantnumber == 5) {
					world.setBlock(BlockPos.containing(x, y, z), AshenremainsModBlocks.SPRUCE_SPROUT.get().defaultBlockState(), 3);
				} else if (Plantnumber == 6) {
					world.setBlock(BlockPos.containing(x, y, z), AshenremainsModBlocks.SPRUCE_SPROUT.get().defaultBlockState(), 3);
				} else if (Plantnumber == 7) {
					if (world instanceof ServerLevel _serverworld) {
						StructureTemplate template = _serverworld.getStructureManager().getOrCreate(ResourceLocation.fromNamespaceAndPath("ashenremains", "tall_grass"));
						if (template != null) {
							template.placeInWorld(_serverworld, BlockPos.containing(x, y, z), BlockPos.containing(x, y, z), new StructurePlaceSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setIgnoreEntities(false), _serverworld.random,
									3);
						}
					}
				} else if (Plantnumber == 8) {
					if (world instanceof ServerLevel _serverworld) {
						StructureTemplate template = _serverworld.getStructureManager().getOrCreate(ResourceLocation.fromNamespaceAndPath("ashenremains", "tall_grass"));
						if (template != null) {
							template.placeInWorld(_serverworld, BlockPos.containing(x, y, z), BlockPos.containing(x, y, z), new StructurePlaceSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setIgnoreEntities(false), _serverworld.random,
									3);
						}
					}
				}
			} else if (world.getBiome(BlockPos.containing(x, y, z)).is(ResourceLocation.parse("meadow")) || world.getBiome(BlockPos.containing(x, y, z)).is(ResourceLocation.parse("flower_forest"))) {
				if (Plantnumber == 0) {
					world.setBlock(BlockPos.containing(x, y, z), Blocks.SHORT_GRASS.defaultBlockState(), 3);
				} else if (Plantnumber == 1) {
					world.setBlock(BlockPos.containing(x, y, z), Blocks.SHORT_GRASS.defaultBlockState(), 3);
				} else if (Plantnumber == 2) {
					if (world instanceof ServerLevel _serverworld) {
						StructureTemplate template = _serverworld.getStructureManager().getOrCreate(ResourceLocation.fromNamespaceAndPath("ashenremains", "tall_grass"));
						if (template != null) {
							template.placeInWorld(_serverworld, BlockPos.containing(x, y, z), BlockPos.containing(x, y, z), new StructurePlaceSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setIgnoreEntities(false), _serverworld.random,
									3);
						}
					}
				} else if (Plantnumber == 3) {
					world.setBlock(BlockPos.containing(x, y, z), Blocks.SHORT_GRASS.defaultBlockState(), 3);
				} else if (Plantnumber == 4 && found == false) {
					world.setBlock(BlockPos.containing(x, y, z), AshenremainsModBlocks.BIRCH_SPROUT.get().defaultBlockState(), 3);
				} else if (Plantnumber == 5) {
					if (world instanceof ServerLevel _serverworld) {
						StructureTemplate template = _serverworld.getStructureManager().getOrCreate(ResourceLocation.fromNamespaceAndPath("ashenremains", "tall_grass"));
						if (template != null) {
							template.placeInWorld(_serverworld, BlockPos.containing(x, y, z), BlockPos.containing(x, y, z), new StructurePlaceSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setIgnoreEntities(false), _serverworld.random,
									3);
						}
					}
				} else if (Plantnumber == 6) {
					world.setBlock(BlockPos.containing(x, y, z), Blocks.SHORT_GRASS.defaultBlockState(), 3);
				} else if (Plantnumber == 7) {
					if (SecondaryPlantNumber == 0) {
						world.setBlock(BlockPos.containing(x, y, z), Blocks.CORNFLOWER.defaultBlockState(), 3);
					} else if (SecondaryPlantNumber == 1) {
						world.setBlock(BlockPos.containing(x, y, z), Blocks.POPPY.defaultBlockState(), 3);
					} else if (SecondaryPlantNumber == 2) {
						world.setBlock(BlockPos.containing(x, y, z), Blocks.ALLIUM.defaultBlockState(), 3);
					} else if (SecondaryPlantNumber == 3) {
						world.setBlock(BlockPos.containing(x, y, z), Blocks.OXEYE_DAISY.defaultBlockState(), 3);
					}
				} else if (Plantnumber == 8) {
					if (SecondaryPlantNumber == 0) {
						world.setBlock(BlockPos.containing(x, y, z), Blocks.DANDELION.defaultBlockState(), 3);
					} else if (SecondaryPlantNumber == 1) {
						world.setBlock(BlockPos.containing(x, y, z), Blocks.AZURE_BLUET.defaultBlockState(), 3);
					} else if (SecondaryPlantNumber == 2) {
						world.setBlock(BlockPos.containing(x, y, z), Blocks.ALLIUM.defaultBlockState(), 3);
					} else if (SecondaryPlantNumber == 3) {
						world.setBlock(BlockPos.containing(x, y, z), Blocks.OXEYE_DAISY.defaultBlockState(), 3);
					}
				}
			} else if (world.getBiome(BlockPos.containing(x, y, z)).is(ResourceLocation.parse("swamp")) || world.getBiome(BlockPos.containing(x, y, z)).is(ResourceLocation.parse("plains"))) {
				if (Plantnumber == 0) {
					if (world instanceof ServerLevel _serverworld) {
						StructureTemplate template = _serverworld.getStructureManager().getOrCreate(ResourceLocation.fromNamespaceAndPath("ashenremains", "tall_grass"));
						if (template != null) {
							template.placeInWorld(_serverworld, BlockPos.containing(x, y, z), BlockPos.containing(x, y, z), new StructurePlaceSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setIgnoreEntities(false), _serverworld.random,
									3);
						}
					}
				} else if (Plantnumber == 1) {
					world.setBlock(BlockPos.containing(x, y, z), Blocks.FERN.defaultBlockState(), 3);
				} else if (Plantnumber == 2) {
					world.setBlock(BlockPos.containing(x, y, z), Blocks.SHORT_GRASS.defaultBlockState(), 3);
				} else if (Plantnumber == 3) {
					if (world instanceof ServerLevel _serverworld) {
						StructureTemplate template = _serverworld.getStructureManager().getOrCreate(ResourceLocation.fromNamespaceAndPath("ashenremains", "tall_grass"));
						if (template != null) {
							template.placeInWorld(_serverworld, BlockPos.containing(x, y, z), BlockPos.containing(x, y, z), new StructurePlaceSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setIgnoreEntities(false), _serverworld.random,
									3);
						}
					}
				} else if (Plantnumber == 4) {
					world.setBlock(BlockPos.containing(x, y, z), Blocks.FERN.defaultBlockState(), 3);
				} else if (Plantnumber == 5) {
					world.setBlock(BlockPos.containing(x, y, z), Blocks.SHORT_GRASS.defaultBlockState(), 3);
				} else if (Plantnumber == 6) {
					world.setBlock(BlockPos.containing(x, y, z), AshenremainsModBlocks.OAK_SPROUT.get().defaultBlockState(), 3);
				} else if (Plantnumber == 7) {
					world.setBlock(BlockPos.containing(x, y, z), Blocks.SHORT_GRASS.defaultBlockState(), 3);
				} else if (Plantnumber == 8) {
					world.setBlock(BlockPos.containing(x, y, z), Blocks.BLUE_ORCHID.defaultBlockState(), 3);
				}
			} else if (world.getBiome(BlockPos.containing(x, y, z)).is(TagKey.create(Registries.BIOME, ResourceLocation.parse("minecraft:is_savanna")))) {
				if (Plantnumber == 0) {
					world.setBlock(BlockPos.containing(x, y, z), Blocks.SHORT_GRASS.defaultBlockState(), 3);
				} else if (Plantnumber == 1) {
					if (world instanceof ServerLevel _serverworld) {
						StructureTemplate template = _serverworld.getStructureManager().getOrCreate(ResourceLocation.fromNamespaceAndPath("ashenremains", "tall_grass"));
						if (template != null) {
							template.placeInWorld(_serverworld, BlockPos.containing(x, y, z), BlockPos.containing(x, y, z), new StructurePlaceSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setIgnoreEntities(false), _serverworld.random,
									3);
						}
					}
				} else if (Plantnumber == 2) {
					world.setBlock(BlockPos.containing(x, y, z), Blocks.SHORT_GRASS.defaultBlockState(), 3);
				} else if (Plantnumber == 3) {
					world.setBlock(BlockPos.containing(x, y, z), Blocks.SHORT_GRASS.defaultBlockState(), 3);
				} else if (Plantnumber == 4) {
					if (world instanceof ServerLevel _serverworld) {
						StructureTemplate template = _serverworld.getStructureManager().getOrCreate(ResourceLocation.fromNamespaceAndPath("ashenremains", "tall_grass"));
						if (template != null) {
							template.placeInWorld(_serverworld, BlockPos.containing(x, y, z), BlockPos.containing(x, y, z), new StructurePlaceSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setIgnoreEntities(false), _serverworld.random,
									3);
						}
					}
				} else if (Plantnumber == 5) {
					world.setBlock(BlockPos.containing(x, y, z), Blocks.SHORT_GRASS.defaultBlockState(), 3);
				} else if (Plantnumber == 6 && found == false) {
					world.setBlock(BlockPos.containing(x, y, z), AshenremainsModBlocks.ACACIA_SPROUT.get().defaultBlockState(), 3);
				} else if (Plantnumber == 7) {
					if (world instanceof ServerLevel _serverworld) {
						StructureTemplate template = _serverworld.getStructureManager().getOrCreate(ResourceLocation.fromNamespaceAndPath("ashenremains", "tall_grass"));
						if (template != null) {
							template.placeInWorld(_serverworld, BlockPos.containing(x, y, z), BlockPos.containing(x, y, z), new StructurePlaceSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setIgnoreEntities(false), _serverworld.random,
									3);
						}
					}
				} else if (Plantnumber == 8) {
					if (SecondaryPlantNumber == 0) {
						world.setBlock(BlockPos.containing(x, y, z), Blocks.DANDELION.defaultBlockState(), 3);
					} else if (SecondaryPlantNumber == 1) {
						world.setBlock(BlockPos.containing(x, y, z), Blocks.POPPY.defaultBlockState(), 3);
					} else if (SecondaryPlantNumber == 2) {
						world.setBlock(BlockPos.containing(x, y, z), Blocks.DANDELION.defaultBlockState(), 3);
					} else if (SecondaryPlantNumber == 3) {
						world.setBlock(BlockPos.containing(x, y, z), Blocks.POPPY.defaultBlockState(), 3);
					}
				}
			} else if (world.getBiome(BlockPos.containing(x, y, z)).is(TagKey.create(Registries.BIOME, ResourceLocation.parse("minecraft:is_taiga")))) {
				if (Plantnumber == 0) {
					world.setBlock(BlockPos.containing(x, y, z), Blocks.SHORT_GRASS.defaultBlockState(), 3);
				} else if (Plantnumber == 1) {
					world.setBlock(BlockPos.containing(x, y, z), Blocks.FERN.defaultBlockState(), 3);
				} else if (Plantnumber == 2 && found == false) {
					world.setBlock(BlockPos.containing(x, y, z), AshenremainsModBlocks.SPRUCE_SPROUT.get().defaultBlockState(), 3);
				} else if (Plantnumber == 3) {
					world.setBlock(BlockPos.containing(x, y, z), Blocks.SHORT_GRASS.defaultBlockState(), 3);
				} else if (Plantnumber == 4 && found == false) {
					world.setBlock(BlockPos.containing(x, y, z), AshenremainsModBlocks.SPRUCE_SPROUT.get().defaultBlockState(), 3);
				} else if (Plantnumber == 5) {
					if (world instanceof ServerLevel _serverworld) {
						StructureTemplate template = _serverworld.getStructureManager().getOrCreate(ResourceLocation.fromNamespaceAndPath("ashenremains", "large_fern"));
						if (template != null) {
							template.placeInWorld(_serverworld, BlockPos.containing(x, y, z), BlockPos.containing(x, y, z), new StructurePlaceSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setIgnoreEntities(false), _serverworld.random,
									3);
						}
					}
				} else if (Plantnumber == 6 && found == false) {
					world.setBlock(BlockPos.containing(x, y, z), AshenremainsModBlocks.SPRUCE_SPROUT.get().defaultBlockState(), 3);
				} else if (Plantnumber == 7) {
					world.setBlock(BlockPos.containing(x, y, z), Blocks.SHORT_GRASS.defaultBlockState(), 3);
				} else if (Plantnumber == 8) {
					if (SecondaryPlantNumber == 0) {
						world.setBlock(BlockPos.containing(x, y, z), AshenremainsModBlocks.SPRUCE_SPROUT.get().defaultBlockState(), 3);
					} else if (SecondaryPlantNumber == 1) {
						world.setBlock(BlockPos.containing(x, y, z), AshenremainsModBlocks.SPRUCE_SPROUT.get().defaultBlockState(), 3);
					} else if (SecondaryPlantNumber == 2) {
						world.setBlock(BlockPos.containing(x, y, z), Blocks.SWEET_BERRY_BUSH.defaultBlockState(), 3);
					} else if (SecondaryPlantNumber == 3) {
						world.setBlock(BlockPos.containing(x, y, z), Blocks.SWEET_BERRY_BUSH.defaultBlockState(), 3);
					}
				}
			} else if (world.getBiome(BlockPos.containing(x, y, z)).is(TagKey.create(Registries.BIOME, ResourceLocation.parse("minecraft:is_jungle")))) {
				if (Plantnumber == 0) {
					world.setBlock(BlockPos.containing(x, y, z), Blocks.SHORT_GRASS.defaultBlockState(), 3);
				} else if (Plantnumber == 1 && found == false) {
					world.setBlock(BlockPos.containing(x, y, z), AshenremainsModBlocks.JUNGLE_SPROUT.get().defaultBlockState(), 3);
				} else if (Plantnumber == 2) {
					world.setBlock(BlockPos.containing(x, y, z), Blocks.BAMBOO_SAPLING.defaultBlockState(), 3);
				} else if (Plantnumber == 3) {
					if (world instanceof ServerLevel _serverworld) {
						StructureTemplate template = _serverworld.getStructureManager().getOrCreate(ResourceLocation.fromNamespaceAndPath("ashenremains", "large_fern"));
						if (template != null) {
							template.placeInWorld(_serverworld, BlockPos.containing(x, y, z), BlockPos.containing(x, y, z), new StructurePlaceSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setIgnoreEntities(false), _serverworld.random,
									3);
						}
					}
				} else if (Plantnumber == 4) {
					world.setBlock(BlockPos.containing(x, y, z), Blocks.FERN.defaultBlockState(), 3);
				} else if (Plantnumber == 5 && found == false) {
					world.setBlock(BlockPos.containing(x, y, z), AshenremainsModBlocks.JUNGLE_SPROUT.get().defaultBlockState(), 3);
				} else if (Plantnumber == 6) {
					world.setBlock(BlockPos.containing(x, y, z), Blocks.SHORT_GRASS.defaultBlockState(), 3);
				} else if (Plantnumber == 7 && found == false) {
					world.setBlock(BlockPos.containing(x, y, z), AshenremainsModBlocks.JUNGLE_SPROUT.get().defaultBlockState(), 3);
				} else if (Plantnumber == 8 && found == false) {
					world.setBlock(BlockPos.containing(x, y, z), AshenremainsModBlocks.OAK_SPROUT.get().defaultBlockState(), 3);
				}
			} else if (world.getBiome(BlockPos.containing(x, y, z)).is(TagKey.create(Registries.BIOME, ResourceLocation.parse("minecraft:is_badlands")))) {
				if (Plantnumber == 0) {
					world.setBlock(BlockPos.containing(x, y, z), Blocks.SHORT_GRASS.defaultBlockState(), 3);
				} else if (Plantnumber == 1) {
					if (world instanceof ServerLevel _serverworld) {
						StructureTemplate template = _serverworld.getStructureManager().getOrCreate(ResourceLocation.fromNamespaceAndPath("ashenremains", "tall_grass"));
						if (template != null) {
							template.placeInWorld(_serverworld, BlockPos.containing(x, y, z), BlockPos.containing(x, y, z), new StructurePlaceSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setIgnoreEntities(false), _serverworld.random,
									3);
						}
					}
				} else if (Plantnumber == 2) {
					if (world instanceof ServerLevel _serverworld) {
						StructureTemplate template = _serverworld.getStructureManager().getOrCreate(ResourceLocation.fromNamespaceAndPath("ashenremains", "tall_grass"));
						if (template != null) {
							template.placeInWorld(_serverworld, BlockPos.containing(x, y, z), BlockPos.containing(x, y, z), new StructurePlaceSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setIgnoreEntities(false), _serverworld.random,
									3);
						}
					}
				} else if (Plantnumber == 3) {
					world.setBlock(BlockPos.containing(x, y, z), Blocks.SHORT_GRASS.defaultBlockState(), 3);
				} else if (Plantnumber == 4 && found == false) {
					world.setBlock(BlockPos.containing(x, y, z), AshenremainsModBlocks.OAK_SPROUT.get().defaultBlockState(), 3);
				} else if (Plantnumber == 5) {
					world.setBlock(BlockPos.containing(x, y, z), Blocks.DEAD_BUSH.defaultBlockState(), 3);
				} else if (Plantnumber == 6 && found == false) {
					world.setBlock(BlockPos.containing(x, y, z), AshenremainsModBlocks.OAK_SPROUT.get().defaultBlockState(), 3);
				} else if (Plantnumber == 7) {
					world.setBlock(BlockPos.containing(x, y, z), Blocks.SHORT_GRASS.defaultBlockState(), 3);
				} else if (Plantnumber == 8) {
					world.setBlock(BlockPos.containing(x, y, z), Blocks.DEAD_BUSH.defaultBlockState(), 3);
				}
			} else if (world.getBiome(BlockPos.containing(x, y, z)).is(ResourceLocation.parse("plains")) || world.getBiome(BlockPos.containing(x, y, z)).is(ResourceLocation.parse("sunflower_plains"))) {
				if (Plantnumber == 0) {
					world.setBlock(BlockPos.containing(x, y, z), Blocks.SHORT_GRASS.defaultBlockState(), 3);
				} else if (Plantnumber == 1) {
					world.setBlock(BlockPos.containing(x, y, z), Blocks.SHORT_GRASS.defaultBlockState(), 3);
				} else if (Plantnumber == 2) {
					if (world instanceof ServerLevel _serverworld) {
						StructureTemplate template = _serverworld.getStructureManager().getOrCreate(ResourceLocation.fromNamespaceAndPath("ashenremains", "tall_grass"));
						if (template != null) {
							template.placeInWorld(_serverworld, BlockPos.containing(x, y, z), BlockPos.containing(x, y, z), new StructurePlaceSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setIgnoreEntities(false), _serverworld.random,
									3);
						}
					}
				} else if (Plantnumber == 3) {
					world.setBlock(BlockPos.containing(x, y, z), Blocks.SHORT_GRASS.defaultBlockState(), 3);
				} else if (Plantnumber == 4) {
					world.setBlock(BlockPos.containing(x, y, z), Blocks.SHORT_GRASS.defaultBlockState(), 3);
				} else if (Plantnumber == 5) {
					if (world instanceof ServerLevel _serverworld) {
						StructureTemplate template = _serverworld.getStructureManager().getOrCreate(ResourceLocation.fromNamespaceAndPath("ashenremains", "tall_grass"));
						if (template != null) {
							template.placeInWorld(_serverworld, BlockPos.containing(x, y, z), BlockPos.containing(x, y, z), new StructurePlaceSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setIgnoreEntities(false), _serverworld.random,
									3);
						}
					}
				} else if (Plantnumber == 6 && found == false) {
					world.setBlock(BlockPos.containing(x, y, z), AshenremainsModBlocks.OAK_SPROUT.get().defaultBlockState(), 3);
				} else if (Plantnumber == 7) {
					world.setBlock(BlockPos.containing(x, y, z), Blocks.SHORT_GRASS.defaultBlockState(), 3);
				} else if (Plantnumber == 8) {
					if (SecondaryPlantNumber == 0) {
						world.setBlock(BlockPos.containing(x, y, z), Blocks.DANDELION.defaultBlockState(), 3);
					} else if (SecondaryPlantNumber == 1) {
						world.setBlock(BlockPos.containing(x, y, z), Blocks.POPPY.defaultBlockState(), 3);
					} else if (SecondaryPlantNumber == 2) {
						world.setBlock(BlockPos.containing(x, y, z), Blocks.CORNFLOWER.defaultBlockState(), 3);
					} else if (SecondaryPlantNumber == 3) {
						world.setBlock(BlockPos.containing(x, y, z), Blocks.OXEYE_DAISY.defaultBlockState(), 3);
					}
				}
			} else if (world.getBiome(BlockPos.containing(x, y, z)).is(ResourceLocation.parse("cherry_grove"))) {
				if (Plantnumber == 0) {
					world.setBlock(BlockPos.containing(x, y, z), Blocks.SHORT_GRASS.defaultBlockState(), 3);
				} else if (Plantnumber == 1) {
					if (world instanceof ServerLevel _serverworld) {
						StructureTemplate template = _serverworld.getStructureManager().getOrCreate(ResourceLocation.fromNamespaceAndPath("ashenremains", "tall_grass"));
						if (template != null) {
							template.placeInWorld(_serverworld, BlockPos.containing(x, y, z), BlockPos.containing(x, y, z), new StructurePlaceSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setIgnoreEntities(false), _serverworld.random,
									3);
						}
					}
				} else if (Plantnumber == 2) {
					if (world instanceof ServerLevel _serverworld) {
						StructureTemplate template = _serverworld.getStructureManager().getOrCreate(ResourceLocation.fromNamespaceAndPath("ashenremains", "tall_grass"));
						if (template != null) {
							template.placeInWorld(_serverworld, BlockPos.containing(x, y, z), BlockPos.containing(x, y, z), new StructurePlaceSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setIgnoreEntities(false), _serverworld.random,
									3);
						}
					}
				} else if (Plantnumber == 3) {
					world.setBlock(BlockPos.containing(x, y, z), Blocks.SHORT_GRASS.defaultBlockState(), 3);
				} else if (Plantnumber == 4 && found == false) {
					world.setBlock(BlockPos.containing(x, y, z), AshenremainsModBlocks.CHERRY_SPROUT.get().defaultBlockState(), 3);
				} else if (Plantnumber == 5) {
					if (world instanceof ServerLevel _level)
						_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
								"/setblock ~ ~ ~ pink_petals[flower_amount=2]");
				} else if (Plantnumber == 6 && found == false) {
					world.setBlock(BlockPos.containing(x, y, z), AshenremainsModBlocks.CHERRY_SPROUT.get().defaultBlockState(), 3);
				} else if (Plantnumber == 7) {
					if (world instanceof ServerLevel _level)
						_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
								"/setblock ~ ~ ~ pink_petals[flower_amount=3]");
				} else if (Plantnumber == 8) {
					if (world instanceof ServerLevel _level)
						_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
								"/setblock ~ ~ ~ pink_petals[flower_amount=4]");
				}
			} else {
				if (Plantnumber == 0) {
					world.setBlock(BlockPos.containing(x, y, z), Blocks.SHORT_GRASS.defaultBlockState(), 3);
				} else if (Plantnumber == 1) {
					world.setBlock(BlockPos.containing(x, y, z), Blocks.SHORT_GRASS.defaultBlockState(), 3);
				} else if (Plantnumber == 2) {
					world.setBlock(BlockPos.containing(x, y, z), Blocks.SHORT_GRASS.defaultBlockState(), 3);
				} else if (Plantnumber == 3) {
					if (world instanceof ServerLevel _serverworld) {
						StructureTemplate template = _serverworld.getStructureManager().getOrCreate(ResourceLocation.fromNamespaceAndPath("ashenremains", "tall_grass"));
						if (template != null) {
							template.placeInWorld(_serverworld, BlockPos.containing(x, y, z), BlockPos.containing(x, y, z), new StructurePlaceSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setIgnoreEntities(false), _serverworld.random,
									3);
						}
					}
				} else if (Plantnumber == 4) {
					world.setBlock(BlockPos.containing(x, y, z), Blocks.SHORT_GRASS.defaultBlockState(), 3);
				} else if (Plantnumber == 5) {
					if (world instanceof ServerLevel _serverworld) {
						StructureTemplate template = _serverworld.getStructureManager().getOrCreate(ResourceLocation.fromNamespaceAndPath("ashenremains", "tall_grass"));
						if (template != null) {
							template.placeInWorld(_serverworld, BlockPos.containing(x, y, z), BlockPos.containing(x, y, z), new StructurePlaceSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setIgnoreEntities(false), _serverworld.random,
									3);
						}
					}
				} else if (Plantnumber == 6) {
					world.setBlock(BlockPos.containing(x, y, z), Blocks.SHORT_GRASS.defaultBlockState(), 3);
				} else if (Plantnumber == 7) {
					world.setBlock(BlockPos.containing(x, y, z), Blocks.SHORT_GRASS.defaultBlockState(), 3);
				} else if (Plantnumber == 8) {
					if (SecondaryPlantNumber == 0) {
						world.setBlock(BlockPos.containing(x, y, z), Blocks.DANDELION.defaultBlockState(), 3);
					} else if (SecondaryPlantNumber == 1) {
						world.setBlock(BlockPos.containing(x, y, z), Blocks.POPPY.defaultBlockState(), 3);
					} else if (SecondaryPlantNumber == 2) {
						world.setBlock(BlockPos.containing(x, y, z), Blocks.CORNFLOWER.defaultBlockState(), 3);
					} else if (SecondaryPlantNumber == 3) {
						world.setBlock(BlockPos.containing(x, y, z), Blocks.OXEYE_DAISY.defaultBlockState(), 3);
					}
				}
			}
		} else {
			if (world.getBiome(BlockPos.containing(x, y, z)).is(ResourceLocation.parse("forest")) || world.getBiome(BlockPos.containing(x, y, z)).is(ResourceLocation.parse("plains"))) {
				if (Plantnumber == 0) {
					world.setBlock(BlockPos.containing(x, y, z), Blocks.SHORT_GRASS.defaultBlockState(), 3);
				} else if (Plantnumber == 1) {
					if (world instanceof ServerLevel _serverworld) {
						StructureTemplate template = _serverworld.getStructureManager().getOrCreate(ResourceLocation.fromNamespaceAndPath("ashenremains", "tall_grass"));
						if (template != null) {
							template.placeInWorld(_serverworld, BlockPos.containing(x, y, z), BlockPos.containing(x, y, z), new StructurePlaceSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setIgnoreEntities(false), _serverworld.random,
									3);
						}
					}
				} else if (Plantnumber == 2) {
					world.setBlock(BlockPos.containing(x, y, z), Blocks.FERN.defaultBlockState(), 3);
				} else if (Plantnumber == 3) {
					world.setBlock(BlockPos.containing(x, y, z), Blocks.SHORT_GRASS.defaultBlockState(), 3);
				} else if (Plantnumber == 4) {
					if (world instanceof ServerLevel _serverworld) {
						StructureTemplate template = _serverworld.getStructureManager().getOrCreate(ResourceLocation.fromNamespaceAndPath("ashenremains", "tall_grass"));
						if (template != null) {
							template.placeInWorld(_serverworld, BlockPos.containing(x, y, z), BlockPos.containing(x, y, z), new StructurePlaceSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setIgnoreEntities(false), _serverworld.random,
									3);
						}
					}
				} else if (Plantnumber == 5) {
					world.setBlock(BlockPos.containing(x, y, z), Blocks.FERN.defaultBlockState(), 3);
				} else if (Plantnumber == 6) {
					world.setBlock(BlockPos.containing(x, y, z), Blocks.SHORT_GRASS.defaultBlockState(), 3);
				} else if (Plantnumber == 7) {
					world.setBlock(BlockPos.containing(x, y, z), Blocks.SHORT_GRASS.defaultBlockState(), 3);
				} else if (Plantnumber == 8) {
					if (SecondaryPlantNumber == 0) {
						world.setBlock(BlockPos.containing(x, y, z), Blocks.POPPY.defaultBlockState(), 3);
					} else if (SecondaryPlantNumber == 1) {
						world.setBlock(BlockPos.containing(x, y, z), Blocks.POPPY.defaultBlockState(), 3);
					} else if (SecondaryPlantNumber == 2) {
						world.setBlock(BlockPos.containing(x, y, z), Blocks.DANDELION.defaultBlockState(), 3);
					} else if (SecondaryPlantNumber == 3) {
						world.setBlock(BlockPos.containing(x, y, z), Blocks.DANDELION.defaultBlockState(), 3);
					}
				}
			} else if (world.getBiome(BlockPos.containing(x, y, z)).is(ResourceLocation.parse("birch_forest")) || world.getBiome(BlockPos.containing(x, y, z)).is(ResourceLocation.parse("plains"))
					|| world.getBiome(BlockPos.containing(x, y, z)).is(ResourceLocation.parse("old_growth_birch_forest")) || world.getBiome(BlockPos.containing(x, y, z)).is(ResourceLocation.parse("plains"))) {
				if (Plantnumber == 0) {
					world.setBlock(BlockPos.containing(x, y, z), Blocks.SHORT_GRASS.defaultBlockState(), 3);
				} else if (Plantnumber == 1) {
					world.setBlock(BlockPos.containing(x, y, z), Blocks.SHORT_GRASS.defaultBlockState(), 3);
				} else if (Plantnumber == 2) {
					if (world instanceof ServerLevel _serverworld) {
						StructureTemplate template = _serverworld.getStructureManager().getOrCreate(ResourceLocation.fromNamespaceAndPath("ashenremains", "tall_grass"));
						if (template != null) {
							template.placeInWorld(_serverworld, BlockPos.containing(x, y, z), BlockPos.containing(x, y, z), new StructurePlaceSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setIgnoreEntities(false), _serverworld.random,
									3);
						}
					}
				} else if (Plantnumber == 3) {
					world.setBlock(BlockPos.containing(x, y, z), Blocks.SHORT_GRASS.defaultBlockState(), 3);
				} else if (Plantnumber == 4) {
					world.setBlock(BlockPos.containing(x, y, z), Blocks.SHORT_GRASS.defaultBlockState(), 3);
				} else if (Plantnumber == 5) {
					if (world instanceof ServerLevel _serverworld) {
						StructureTemplate template = _serverworld.getStructureManager().getOrCreate(ResourceLocation.fromNamespaceAndPath("ashenremains", "tall_grass"));
						if (template != null) {
							template.placeInWorld(_serverworld, BlockPos.containing(x, y, z), BlockPos.containing(x, y, z), new StructurePlaceSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setIgnoreEntities(false), _serverworld.random,
									3);
						}
					}
				} else if (Plantnumber == 6) {
					world.setBlock(BlockPos.containing(x, y, z), Blocks.SHORT_GRASS.defaultBlockState(), 3);
				} else if (Plantnumber == 7) {
					if (world instanceof ServerLevel _serverworld) {
						StructureTemplate template = _serverworld.getStructureManager().getOrCreate(ResourceLocation.fromNamespaceAndPath("ashenremains", "tall_grass"));
						if (template != null) {
							template.placeInWorld(_serverworld, BlockPos.containing(x, y, z), BlockPos.containing(x, y, z), new StructurePlaceSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setIgnoreEntities(false), _serverworld.random,
									3);
						}
					}
				} else if (Plantnumber == 8) {
					if (SecondaryPlantNumber == 0) {
						world.setBlock(BlockPos.containing(x, y, z), Blocks.ALLIUM.defaultBlockState(), 3);
					} else if (SecondaryPlantNumber == 1) {
						world.setBlock(BlockPos.containing(x, y, z), Blocks.AZURE_BLUET.defaultBlockState(), 3);
					} else if (SecondaryPlantNumber == 2) {
						world.setBlock(BlockPos.containing(x, y, z), Blocks.OXEYE_DAISY.defaultBlockState(), 3);
					} else if (SecondaryPlantNumber == 3) {
						world.setBlock(BlockPos.containing(x, y, z), Blocks.LILY_OF_THE_VALLEY.defaultBlockState(), 3);
					}
				}
			} else if (world.getBiome(BlockPos.containing(x, y, z)).is(ResourceLocation.parse("dark_forest")) || world.getBiome(BlockPos.containing(x, y, z)).is(ResourceLocation.parse("plains"))) {
				if (Plantnumber == 0 && found == false) {
					world.setBlock(BlockPos.containing(x, y, z), AshenremainsModBlocks.BIRCH_SPROUT.get().defaultBlockState(), 3);
				} else if (Plantnumber == 1 && found == false) {
					world.setBlock(BlockPos.containing(x, y, z), AshenremainsModBlocks.DARK_OAK_SPROUT.get().defaultBlockState(), 3);
				} else if (Plantnumber == 2) {
					world.setBlock(BlockPos.containing(x, y, z), Blocks.SHORT_GRASS.defaultBlockState(), 3);
				} else if (Plantnumber == 3) {
					world.setBlock(BlockPos.containing(x, y, z), Blocks.RED_MUSHROOM.defaultBlockState(), 3);
				} else if (Plantnumber == 4) {
					world.setBlock(BlockPos.containing(x, y, z), Blocks.FERN.defaultBlockState(), 3);
				} else if (Plantnumber == 5 && found == false) {
					world.setBlock(BlockPos.containing(x, y, z), AshenremainsModBlocks.DARK_OAK_SPROUT.get().defaultBlockState(), 3);
				} else if (Plantnumber == 6) {
					world.setBlock(BlockPos.containing(x, y, z), Blocks.FERN.defaultBlockState(), 3);
				} else if (Plantnumber == 7) {
					world.setBlock(BlockPos.containing(x, y, z), Blocks.BROWN_MUSHROOM.defaultBlockState(), 3);
				} else if (Plantnumber == 8 && found == false) {
					world.setBlock(BlockPos.containing(x, y, z), AshenremainsModBlocks.DARK_OAK_SPROUT.get().defaultBlockState(), 3);
				}
			} else if (world.getBiome(BlockPos.containing(x, y, z)).is(ResourceLocation.parse("windswept_forest")) || world.getBiome(BlockPos.containing(x, y, z)).is(ResourceLocation.parse("windswept_gravelly_hills"))
					|| world.getBiome(BlockPos.containing(x, y, z)).is(ResourceLocation.parse("windswept_hills"))) {
				if (Plantnumber == 0) {
					world.setBlock(BlockPos.containing(x, y, z), Blocks.SHORT_GRASS.defaultBlockState(), 3);
				} else if (Plantnumber == 1) {
					world.setBlock(BlockPos.containing(x, y, z), Blocks.SHORT_GRASS.defaultBlockState(), 3);
				} else if (Plantnumber == 2) {
					world.setBlock(BlockPos.containing(x, y, z), Blocks.FERN.defaultBlockState(), 3);
				} else if (Plantnumber == 3) {
					world.setBlock(BlockPos.containing(x, y, z), Blocks.SHORT_GRASS.defaultBlockState(), 3);
				} else if (Plantnumber == 4) {
					world.setBlock(BlockPos.containing(x, y, z), Blocks.SHORT_GRASS.defaultBlockState(), 3);
				} else if (Plantnumber == 5) {
					world.setBlock(BlockPos.containing(x, y, z), Blocks.FERN.defaultBlockState(), 3);
				} else if (Plantnumber == 6) {
					world.setBlock(BlockPos.containing(x, y, z), Blocks.SHORT_GRASS.defaultBlockState(), 3);
				} else if (Plantnumber == 7) {
					if (world instanceof ServerLevel _serverworld) {
						StructureTemplate template = _serverworld.getStructureManager().getOrCreate(ResourceLocation.fromNamespaceAndPath("ashenremains", "tall_grass"));
						if (template != null) {
							template.placeInWorld(_serverworld, BlockPos.containing(x, y, z), BlockPos.containing(x, y, z), new StructurePlaceSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setIgnoreEntities(false), _serverworld.random,
									3);
						}
					}
				} else if (Plantnumber == 8) {
					if (world instanceof ServerLevel _serverworld) {
						StructureTemplate template = _serverworld.getStructureManager().getOrCreate(ResourceLocation.fromNamespaceAndPath("ashenremains", "tall_grass"));
						if (template != null) {
							template.placeInWorld(_serverworld, BlockPos.containing(x, y, z), BlockPos.containing(x, y, z), new StructurePlaceSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setIgnoreEntities(false), _serverworld.random,
									3);
						}
					}
				}
			} else if (world.getBiome(BlockPos.containing(x, y, z)).is(ResourceLocation.parse("meadow")) || world.getBiome(BlockPos.containing(x, y, z)).is(ResourceLocation.parse("flower_forest"))) {
				if (Plantnumber == 0) {
					world.setBlock(BlockPos.containing(x, y, z), Blocks.SHORT_GRASS.defaultBlockState(), 3);
				} else if (Plantnumber == 1) {
					world.setBlock(BlockPos.containing(x, y, z), Blocks.SHORT_GRASS.defaultBlockState(), 3);
				} else if (Plantnumber == 2) {
					if (world instanceof ServerLevel _serverworld) {
						StructureTemplate template = _serverworld.getStructureManager().getOrCreate(ResourceLocation.fromNamespaceAndPath("ashenremains", "tall_grass"));
						if (template != null) {
							template.placeInWorld(_serverworld, BlockPos.containing(x, y, z), BlockPos.containing(x, y, z), new StructurePlaceSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setIgnoreEntities(false), _serverworld.random,
									3);
						}
					}
				} else if (Plantnumber == 3) {
					world.setBlock(BlockPos.containing(x, y, z), Blocks.SHORT_GRASS.defaultBlockState(), 3);
				} else if (Plantnumber == 4) {
					world.setBlock(BlockPos.containing(x, y, z), Blocks.SHORT_GRASS.defaultBlockState(), 3);
				} else if (Plantnumber == 5) {
					if (world instanceof ServerLevel _serverworld) {
						StructureTemplate template = _serverworld.getStructureManager().getOrCreate(ResourceLocation.fromNamespaceAndPath("ashenremains", "tall_grass"));
						if (template != null) {
							template.placeInWorld(_serverworld, BlockPos.containing(x, y, z), BlockPos.containing(x, y, z), new StructurePlaceSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setIgnoreEntities(false), _serverworld.random,
									3);
						}
					}
				} else if (Plantnumber == 6) {
					world.setBlock(BlockPos.containing(x, y, z), Blocks.SHORT_GRASS.defaultBlockState(), 3);
				} else if (Plantnumber == 7) {
					if (SecondaryPlantNumber == 0) {
						world.setBlock(BlockPos.containing(x, y, z), Blocks.CORNFLOWER.defaultBlockState(), 3);
					} else if (SecondaryPlantNumber == 1) {
						world.setBlock(BlockPos.containing(x, y, z), Blocks.POPPY.defaultBlockState(), 3);
					} else if (SecondaryPlantNumber == 2) {
						world.setBlock(BlockPos.containing(x, y, z), Blocks.ALLIUM.defaultBlockState(), 3);
					} else if (SecondaryPlantNumber == 3) {
						world.setBlock(BlockPos.containing(x, y, z), Blocks.OXEYE_DAISY.defaultBlockState(), 3);
					}
				} else if (Plantnumber == 8) {
					if (SecondaryPlantNumber == 0) {
						world.setBlock(BlockPos.containing(x, y, z), Blocks.DANDELION.defaultBlockState(), 3);
					} else if (SecondaryPlantNumber == 1) {
						world.setBlock(BlockPos.containing(x, y, z), Blocks.AZURE_BLUET.defaultBlockState(), 3);
					} else if (SecondaryPlantNumber == 2) {
						world.setBlock(BlockPos.containing(x, y, z), Blocks.ALLIUM.defaultBlockState(), 3);
					} else if (SecondaryPlantNumber == 3) {
						world.setBlock(BlockPos.containing(x, y, z), Blocks.OXEYE_DAISY.defaultBlockState(), 3);
					}
				}
			} else if (world.getBiome(BlockPos.containing(x, y, z)).is(ResourceLocation.parse("swamp")) || world.getBiome(BlockPos.containing(x, y, z)).is(ResourceLocation.parse("plains"))) {
				if (Plantnumber == 0) {
					if (world instanceof ServerLevel _serverworld) {
						StructureTemplate template = _serverworld.getStructureManager().getOrCreate(ResourceLocation.fromNamespaceAndPath("ashenremains", "tall_grass"));
						if (template != null) {
							template.placeInWorld(_serverworld, BlockPos.containing(x, y, z), BlockPos.containing(x, y, z), new StructurePlaceSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setIgnoreEntities(false), _serverworld.random,
									3);
						}
					}
				} else if (Plantnumber == 1) {
					world.setBlock(BlockPos.containing(x, y, z), Blocks.FERN.defaultBlockState(), 3);
				} else if (Plantnumber == 2) {
					world.setBlock(BlockPos.containing(x, y, z), Blocks.SHORT_GRASS.defaultBlockState(), 3);
				} else if (Plantnumber == 3) {
					if (world instanceof ServerLevel _serverworld) {
						StructureTemplate template = _serverworld.getStructureManager().getOrCreate(ResourceLocation.fromNamespaceAndPath("ashenremains", "tall_grass"));
						if (template != null) {
							template.placeInWorld(_serverworld, BlockPos.containing(x, y, z), BlockPos.containing(x, y, z), new StructurePlaceSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setIgnoreEntities(false), _serverworld.random,
									3);
						}
					}
				} else if (Plantnumber == 4) {
					world.setBlock(BlockPos.containing(x, y, z), Blocks.FERN.defaultBlockState(), 3);
				} else if (Plantnumber == 5) {
					world.setBlock(BlockPos.containing(x, y, z), Blocks.SHORT_GRASS.defaultBlockState(), 3);
				} else if (Plantnumber == 6) {
					world.setBlock(BlockPos.containing(x, y, z), Blocks.SHORT_GRASS.defaultBlockState(), 3);
				} else if (Plantnumber == 7) {
					world.setBlock(BlockPos.containing(x, y, z), Blocks.SHORT_GRASS.defaultBlockState(), 3);
				} else if (Plantnumber == 8) {
					world.setBlock(BlockPos.containing(x, y, z), Blocks.BLUE_ORCHID.defaultBlockState(), 3);
				}
			} else if (world.getBiome(BlockPos.containing(x, y, z)).is(TagKey.create(Registries.BIOME, ResourceLocation.parse("minecraft:is_savanna")))) {
				if (Plantnumber == 0) {
					world.setBlock(BlockPos.containing(x, y, z), Blocks.SHORT_GRASS.defaultBlockState(), 3);
				} else if (Plantnumber == 1) {
					if (world instanceof ServerLevel _serverworld) {
						StructureTemplate template = _serverworld.getStructureManager().getOrCreate(ResourceLocation.fromNamespaceAndPath("ashenremains", "tall_grass"));
						if (template != null) {
							template.placeInWorld(_serverworld, BlockPos.containing(x, y, z), BlockPos.containing(x, y, z), new StructurePlaceSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setIgnoreEntities(false), _serverworld.random,
									3);
						}
					}
				} else if (Plantnumber == 2) {
					world.setBlock(BlockPos.containing(x, y, z), Blocks.SHORT_GRASS.defaultBlockState(), 3);
				} else if (Plantnumber == 3) {
					world.setBlock(BlockPos.containing(x, y, z), Blocks.SHORT_GRASS.defaultBlockState(), 3);
				} else if (Plantnumber == 4) {
					if (world instanceof ServerLevel _serverworld) {
						StructureTemplate template = _serverworld.getStructureManager().getOrCreate(ResourceLocation.fromNamespaceAndPath("ashenremains", "tall_grass"));
						if (template != null) {
							template.placeInWorld(_serverworld, BlockPos.containing(x, y, z), BlockPos.containing(x, y, z), new StructurePlaceSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setIgnoreEntities(false), _serverworld.random,
									3);
						}
					}
				} else if (Plantnumber == 5) {
					world.setBlock(BlockPos.containing(x, y, z), Blocks.SHORT_GRASS.defaultBlockState(), 3);
				} else if (Plantnumber == 6) {
					world.setBlock(BlockPos.containing(x, y, z), Blocks.SHORT_GRASS.defaultBlockState(), 3);
				} else if (Plantnumber == 7) {
					if (world instanceof ServerLevel _serverworld) {
						StructureTemplate template = _serverworld.getStructureManager().getOrCreate(ResourceLocation.fromNamespaceAndPath("ashenremains", "tall_grass"));
						if (template != null) {
							template.placeInWorld(_serverworld, BlockPos.containing(x, y, z), BlockPos.containing(x, y, z), new StructurePlaceSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setIgnoreEntities(false), _serverworld.random,
									3);
						}
					}
				} else if (Plantnumber == 8) {
					if (SecondaryPlantNumber == 0) {
						world.setBlock(BlockPos.containing(x, y, z), Blocks.DANDELION.defaultBlockState(), 3);
					} else if (SecondaryPlantNumber == 1) {
						world.setBlock(BlockPos.containing(x, y, z), Blocks.POPPY.defaultBlockState(), 3);
					} else if (SecondaryPlantNumber == 2) {
						world.setBlock(BlockPos.containing(x, y, z), Blocks.DANDELION.defaultBlockState(), 3);
					} else if (SecondaryPlantNumber == 3) {
						world.setBlock(BlockPos.containing(x, y, z), Blocks.POPPY.defaultBlockState(), 3);
					}
				}
			} else if (world.getBiome(BlockPos.containing(x, y, z)).is(TagKey.create(Registries.BIOME, ResourceLocation.parse("minecraft:is_taiga")))) {
				if (Plantnumber == 0) {
					world.setBlock(BlockPos.containing(x, y, z), Blocks.SHORT_GRASS.defaultBlockState(), 3);
				} else if (Plantnumber == 1) {
					world.setBlock(BlockPos.containing(x, y, z), Blocks.FERN.defaultBlockState(), 3);
				} else if (Plantnumber == 2) {
					if (world instanceof ServerLevel _serverworld) {
						StructureTemplate template = _serverworld.getStructureManager().getOrCreate(ResourceLocation.fromNamespaceAndPath("ashenremains", "large_fern"));
						if (template != null) {
							template.placeInWorld(_serverworld, BlockPos.containing(x, y, z), BlockPos.containing(x, y, z), new StructurePlaceSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setIgnoreEntities(false), _serverworld.random,
									3);
						}
					}
				} else if (Plantnumber == 3) {
					world.setBlock(BlockPos.containing(x, y, z), Blocks.SHORT_GRASS.defaultBlockState(), 3);
				} else if (Plantnumber == 4) {
					world.setBlock(BlockPos.containing(x, y, z), Blocks.FERN.defaultBlockState(), 3);
				} else if (Plantnumber == 5) {
					if (world instanceof ServerLevel _serverworld) {
						StructureTemplate template = _serverworld.getStructureManager().getOrCreate(ResourceLocation.fromNamespaceAndPath("ashenremains", "large_fern"));
						if (template != null) {
							template.placeInWorld(_serverworld, BlockPos.containing(x, y, z), BlockPos.containing(x, y, z), new StructurePlaceSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setIgnoreEntities(false), _serverworld.random,
									3);
						}
					}
				} else if (Plantnumber == 6) {
					world.setBlock(BlockPos.containing(x, y, z), Blocks.SHORT_GRASS.defaultBlockState(), 3);
				} else if (Plantnumber == 7) {
					world.setBlock(BlockPos.containing(x, y, z), Blocks.SHORT_GRASS.defaultBlockState(), 3);
				} else if (Plantnumber == 8) {
					if (SecondaryPlantNumber == 0) {
						world.setBlock(BlockPos.containing(x, y, z), Blocks.BROWN_MUSHROOM.defaultBlockState(), 3);
					} else if (SecondaryPlantNumber == 1) {
						world.setBlock(BlockPos.containing(x, y, z), Blocks.RED_MUSHROOM.defaultBlockState(), 3);
					} else if (SecondaryPlantNumber == 2) {
						world.setBlock(BlockPos.containing(x, y, z), Blocks.SWEET_BERRY_BUSH.defaultBlockState(), 3);
					} else if (SecondaryPlantNumber == 3) {
						world.setBlock(BlockPos.containing(x, y, z), Blocks.SWEET_BERRY_BUSH.defaultBlockState(), 3);
					}
				}
			} else if (world.getBiome(BlockPos.containing(x, y, z)).is(TagKey.create(Registries.BIOME, ResourceLocation.parse("minecraft:is_jungle")))) {
				if (Plantnumber == 0) {
					world.setBlock(BlockPos.containing(x, y, z), Blocks.SHORT_GRASS.defaultBlockState(), 3);
				} else if (Plantnumber == 1) {
					world.setBlock(BlockPos.containing(x, y, z), Blocks.SHORT_GRASS.defaultBlockState(), 3);
				} else if (Plantnumber == 2) {
					world.setBlock(BlockPos.containing(x, y, z), Blocks.BAMBOO_SAPLING.defaultBlockState(), 3);
				} else if (Plantnumber == 3) {
					if (world instanceof ServerLevel _serverworld) {
						StructureTemplate template = _serverworld.getStructureManager().getOrCreate(ResourceLocation.fromNamespaceAndPath("ashenremains", "large_fern"));
						if (template != null) {
							template.placeInWorld(_serverworld, BlockPos.containing(x, y, z), BlockPos.containing(x, y, z), new StructurePlaceSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setIgnoreEntities(false), _serverworld.random,
									3);
						}
					}
				} else if (Plantnumber == 4) {
					world.setBlock(BlockPos.containing(x, y, z), Blocks.FERN.defaultBlockState(), 3);
				} else if (Plantnumber == 5) {
					world.setBlock(BlockPos.containing(x, y, z), Blocks.BAMBOO_SAPLING.defaultBlockState(), 3);
				} else if (Plantnumber == 6) {
					world.setBlock(BlockPos.containing(x, y, z), Blocks.SHORT_GRASS.defaultBlockState(), 3);
				} else if (Plantnumber == 7) {
					world.setBlock(BlockPos.containing(x, y, z), Blocks.BAMBOO_SAPLING.defaultBlockState(), 3);
				} else if (Plantnumber == 8) {
					world.setBlock(BlockPos.containing(x, y, z), Blocks.SHORT_GRASS.defaultBlockState(), 3);
				}
			} else if (world.getBiome(BlockPos.containing(x, y, z)).is(TagKey.create(Registries.BIOME, ResourceLocation.parse("minecraft:is_badlands")))) {
				if (Plantnumber == 0) {
					world.setBlock(BlockPos.containing(x, y, z), Blocks.SHORT_GRASS.defaultBlockState(), 3);
				} else if (Plantnumber == 1) {
					if (world instanceof ServerLevel _serverworld) {
						StructureTemplate template = _serverworld.getStructureManager().getOrCreate(ResourceLocation.fromNamespaceAndPath("ashenremains", "tall_grass"));
						if (template != null) {
							template.placeInWorld(_serverworld, BlockPos.containing(x, y, z), BlockPos.containing(x, y, z), new StructurePlaceSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setIgnoreEntities(false), _serverworld.random,
									3);
						}
					}
				} else if (Plantnumber == 2) {
					if (world instanceof ServerLevel _serverworld) {
						StructureTemplate template = _serverworld.getStructureManager().getOrCreate(ResourceLocation.fromNamespaceAndPath("ashenremains", "tall_grass"));
						if (template != null) {
							template.placeInWorld(_serverworld, BlockPos.containing(x, y, z), BlockPos.containing(x, y, z), new StructurePlaceSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setIgnoreEntities(false), _serverworld.random,
									3);
						}
					}
				} else if (Plantnumber == 3) {
					world.setBlock(BlockPos.containing(x, y, z), Blocks.SHORT_GRASS.defaultBlockState(), 3);
				} else if (Plantnumber == 4) {
					world.setBlock(BlockPos.containing(x, y, z), Blocks.DEAD_BUSH.defaultBlockState(), 3);
				} else if (Plantnumber == 5) {
					world.setBlock(BlockPos.containing(x, y, z), Blocks.DEAD_BUSH.defaultBlockState(), 3);
				} else if (Plantnumber == 6) {
					world.setBlock(BlockPos.containing(x, y, z), Blocks.SHORT_GRASS.defaultBlockState(), 3);
				} else if (Plantnumber == 7) {
					world.setBlock(BlockPos.containing(x, y, z), Blocks.SHORT_GRASS.defaultBlockState(), 3);
				} else if (Plantnumber == 8) {
					world.setBlock(BlockPos.containing(x, y, z), Blocks.DEAD_BUSH.defaultBlockState(), 3);
				}
			} else if (world.getBiome(BlockPos.containing(x, y, z)).is(ResourceLocation.parse("cherry_grove"))) {
				if (Plantnumber == 0) {
					world.setBlock(BlockPos.containing(x, y, z), Blocks.SHORT_GRASS.defaultBlockState(), 3);
				} else if (Plantnumber == 1) {
					if (world instanceof ServerLevel _serverworld) {
						StructureTemplate template = _serverworld.getStructureManager().getOrCreate(ResourceLocation.fromNamespaceAndPath("ashenremains", "tall_grass"));
						if (template != null) {
							template.placeInWorld(_serverworld, BlockPos.containing(x, y, z), BlockPos.containing(x, y, z), new StructurePlaceSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setIgnoreEntities(false), _serverworld.random,
									3);
						}
					}
				} else if (Plantnumber == 2) {
					if (world instanceof ServerLevel _serverworld) {
						StructureTemplate template = _serverworld.getStructureManager().getOrCreate(ResourceLocation.fromNamespaceAndPath("ashenremains", "tall_grass"));
						if (template != null) {
							template.placeInWorld(_serverworld, BlockPos.containing(x, y, z), BlockPos.containing(x, y, z), new StructurePlaceSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setIgnoreEntities(false), _serverworld.random,
									3);
						}
					}
				} else if (Plantnumber == 3) {
					world.setBlock(BlockPos.containing(x, y, z), Blocks.SHORT_GRASS.defaultBlockState(), 3);
				} else if (Plantnumber == 4 && found == false) {
					world.setBlock(BlockPos.containing(x, y, z), Blocks.SHORT_GRASS.defaultBlockState(), 3);
				} else if (Plantnumber == 5) {
					if (world instanceof ServerLevel _level)
						_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
								"/setblock ~ ~ ~ pink_petals[flower_amount=1]");
				} else if (Plantnumber == 6 && found == false) {
					if (world instanceof ServerLevel _level)
						_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
								"/setblock ~ ~ ~ pink_petals[flower_amount=2]");
				} else if (Plantnumber == 7) {
					if (world instanceof ServerLevel _level)
						_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
								"/setblock ~ ~ ~ pink_petals[flower_amount=3]");
				} else if (Plantnumber == 8) {
					if (world instanceof ServerLevel _level)
						_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
								"/setblock ~ ~ ~ pink_petals[flower_amount=4]");
				}
			} else if (world.getBiome(BlockPos.containing(x, y, z)).is(ResourceLocation.parse("plains")) || world.getBiome(BlockPos.containing(x, y, z)).is(ResourceLocation.parse("sunflower_plains"))) {
				if (Plantnumber == 0) {
					world.setBlock(BlockPos.containing(x, y, z), Blocks.SHORT_GRASS.defaultBlockState(), 3);
				} else if (Plantnumber == 1) {
					world.setBlock(BlockPos.containing(x, y, z), Blocks.SHORT_GRASS.defaultBlockState(), 3);
				} else if (Plantnumber == 2) {
					if (world instanceof ServerLevel _serverworld) {
						StructureTemplate template = _serverworld.getStructureManager().getOrCreate(ResourceLocation.fromNamespaceAndPath("ashenremains", "tall_grass"));
						if (template != null) {
							template.placeInWorld(_serverworld, BlockPos.containing(x, y, z), BlockPos.containing(x, y, z), new StructurePlaceSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setIgnoreEntities(false), _serverworld.random,
									3);
						}
					}
				} else if (Plantnumber == 3) {
					world.setBlock(BlockPos.containing(x, y, z), Blocks.SHORT_GRASS.defaultBlockState(), 3);
				} else if (Plantnumber == 4) {
					world.setBlock(BlockPos.containing(x, y, z), Blocks.SHORT_GRASS.defaultBlockState(), 3);
				} else if (Plantnumber == 5) {
					if (world instanceof ServerLevel _serverworld) {
						StructureTemplate template = _serverworld.getStructureManager().getOrCreate(ResourceLocation.fromNamespaceAndPath("ashenremains", "tall_grass"));
						if (template != null) {
							template.placeInWorld(_serverworld, BlockPos.containing(x, y, z), BlockPos.containing(x, y, z), new StructurePlaceSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setIgnoreEntities(false), _serverworld.random,
									3);
						}
					}
				} else if (Plantnumber == 6) {
					world.setBlock(BlockPos.containing(x, y, z), Blocks.SHORT_GRASS.defaultBlockState(), 3);
				} else if (Plantnumber == 7) {
					world.setBlock(BlockPos.containing(x, y, z), Blocks.SHORT_GRASS.defaultBlockState(), 3);
				} else if (Plantnumber == 8) {
					if (SecondaryPlantNumber == 0) {
						world.setBlock(BlockPos.containing(x, y, z), Blocks.DANDELION.defaultBlockState(), 3);
					} else if (SecondaryPlantNumber == 1) {
						world.setBlock(BlockPos.containing(x, y, z), Blocks.POPPY.defaultBlockState(), 3);
					} else if (SecondaryPlantNumber == 2) {
						world.setBlock(BlockPos.containing(x, y, z), Blocks.CORNFLOWER.defaultBlockState(), 3);
					} else if (SecondaryPlantNumber == 3) {
						world.setBlock(BlockPos.containing(x, y, z), Blocks.OXEYE_DAISY.defaultBlockState(), 3);
					}
				}
			} else {
				if (Plantnumber == 0) {
					world.setBlock(BlockPos.containing(x, y, z), Blocks.SHORT_GRASS.defaultBlockState(), 3);
				} else if (Plantnumber == 1) {
					world.setBlock(BlockPos.containing(x, y, z), Blocks.SHORT_GRASS.defaultBlockState(), 3);
				} else if (Plantnumber == 2) {
					world.setBlock(BlockPos.containing(x, y, z), Blocks.SHORT_GRASS.defaultBlockState(), 3);
				} else if (Plantnumber == 3) {
					if (world instanceof ServerLevel _serverworld) {
						StructureTemplate template = _serverworld.getStructureManager().getOrCreate(ResourceLocation.fromNamespaceAndPath("ashenremains", "tall_grass"));
						if (template != null) {
							template.placeInWorld(_serverworld, BlockPos.containing(x, y, z), BlockPos.containing(x, y, z), new StructurePlaceSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setIgnoreEntities(false), _serverworld.random,
									3);
						}
					}
				} else if (Plantnumber == 4) {
					world.setBlock(BlockPos.containing(x, y, z), Blocks.SHORT_GRASS.defaultBlockState(), 3);
				} else if (Plantnumber == 5) {
					if (world instanceof ServerLevel _serverworld) {
						StructureTemplate template = _serverworld.getStructureManager().getOrCreate(ResourceLocation.fromNamespaceAndPath("ashenremains", "tall_grass"));
						if (template != null) {
							template.placeInWorld(_serverworld, BlockPos.containing(x, y, z), BlockPos.containing(x, y, z), new StructurePlaceSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setIgnoreEntities(false), _serverworld.random,
									3);
						}
					}
				} else if (Plantnumber == 6) {
					world.setBlock(BlockPos.containing(x, y, z), Blocks.SHORT_GRASS.defaultBlockState(), 3);
				} else if (Plantnumber == 7) {
					world.setBlock(BlockPos.containing(x, y, z), Blocks.SHORT_GRASS.defaultBlockState(), 3);
				} else if (Plantnumber == 8) {
					if (SecondaryPlantNumber == 0) {
						world.setBlock(BlockPos.containing(x, y, z), Blocks.DANDELION.defaultBlockState(), 3);
					} else if (SecondaryPlantNumber == 1) {
						world.setBlock(BlockPos.containing(x, y, z), Blocks.POPPY.defaultBlockState(), 3);
					} else if (SecondaryPlantNumber == 2) {
						world.setBlock(BlockPos.containing(x, y, z), Blocks.CORNFLOWER.defaultBlockState(), 3);
					} else if (SecondaryPlantNumber == 3) {
						world.setBlock(BlockPos.containing(x, y, z), Blocks.OXEYE_DAISY.defaultBlockState(), 3);
					}
				}
			}
		}
	}
}
