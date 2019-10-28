package com.robertx22.mine_and_slash.uncommon.utilityclasses;

import com.robertx22.mine_and_slash.config.dimension_configs.DimensionConfig;
import com.robertx22.mine_and_slash.db_lists.registry.SlashRegistry;
import com.robertx22.mine_and_slash.uncommon.datasaving.Load;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.EntityPredicates;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;

public class LevelUtils {

    public static int determineLevel(World world, BlockPos pos) {

        DimensionConfig dimConfig = SlashRegistry.getDimensionConfig(world);

        int lvl = dimConfig.MINIMUM_MOB_LEVEL;
        double distance = world.getSpawnPoint().manhattanDistance(pos);

        if (distance > dimConfig.MOB_LEVEL_ONE_AREA) {
            lvl = (int) (1 + ((distance - dimConfig.MOB_LEVEL_ONE_AREA) / dimConfig.MOB_LEVEL_PER_DISTANCE));
        }

        if (dimConfig.SCALE_MOB_LEVEL_TO_NEAREST_PLAYER) {
            PlayerEntity player = world.getClosestPlayer(pos.getX(), pos.getY(), pos.getZ(), (double) 3000, EntityPredicates.NOT_SPECTATING);

            if (player != null) {
                int playerLevel= Load.Unit(player).getLevel();
                if(playerLevel<lvl){
                    lvl= RandomUtils.RandomRange(playerLevel,lvl);
                }else{
                    lvl= RandomUtils.RandomRange(lvl,playerLevel);
                }
            }

        }

        lvl = MathHelper.clamp(lvl, dimConfig.MINIMUM_MOB_LEVEL, dimConfig.MAXIMUM_MOB_LEVEL);
        return lvl;
    }

    public static int determineLevelPerDistanceFromSpawn(World world, BlockPos pos,
                                                         DimensionConfig config) {

        double distance = world.getSpawnPoint().manhattanDistance(pos);

        int lvl = 1;

        if (distance < config.MOB_LEVEL_ONE_AREA) {
            lvl = config.MINIMUM_MOB_LEVEL;
        } else {
            lvl = (int) (1 + ((distance - config.MOB_LEVEL_ONE_AREA) / config.MOB_LEVEL_PER_DISTANCE));
        }

        return MathHelper.clamp(lvl, config.MINIMUM_MOB_LEVEL, config.MAXIMUM_MOB_LEVEL);

    }

    public static BlockPos getAreaPosOfLevel(World world, int level,
                                             DimensionConfig config) {

        if (level == 1) {
            return world.getSpawnPoint();
        }

        int distance = config.MOB_LEVEL_PER_DISTANCE * level;

        BlockPos pos = new BlockPos(distance, 0, world.getSpawnPoint().getZ());

        return pos;

    }

    public static int determineLevelPerDistanceFromSpawn(World world, BlockPos pos) {

        return determineLevelPerDistanceFromSpawn(world, pos, SlashRegistry.getDimensionConfig(world));

    }

}
