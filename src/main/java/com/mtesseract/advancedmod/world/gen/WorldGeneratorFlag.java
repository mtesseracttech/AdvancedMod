package com.mtesseract.advancedmod.world.gen;

import com.mtesseract.advancedmod.init.ModBlocks;
import cpw.mods.fml.common.IWorldGenerator;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;

import java.util.Random;

/**
 * Created in IntelliJ IDEA
 * User: mtesseract
 * Project: AdvancedMod
 * Date: 06-05-15
 * Time: 02:09
 */

public class WorldGeneratorFlag implements IWorldGenerator
{
    private WorldGenMinable flagOre = new WorldGenMinable(ModBlocks.dutchFlag, 32);

    @Override
    public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider)
    {
        int x = chunkX * 16;
        int z = chunkZ * 16;
        switch(world.provider.dimensionId)
        {
            case 0:
                generateOverworld(world, x, z, random);
                break;
            case 1:
                generateEnd(world, x, z, random);
                break;
            case 2:
                generateNether(world, x, z, random);
                break;
            default:
                generateDefault(world, x, z, random);
                break;
        }
    }

    private void generateDefault(World world, int x, int z, Random random)
    {
        generateFlag(world, x, z, random);
    }

    private void generateOverworld(World world, int x, int z, Random random)
    {
        generateFlag(world, x, z, random);
        generateFlagOre(world, x, z, random);
    }

    private void generateEnd(World world, int x, int z, Random random)
    {

    }

    private void generateNether(World world, int x, int z, Random random)
    {

    }

    private void generateFlag(World world, int x, int z, Random random)
    {
        if(random.nextInt(10) == 0)
        {
            int randX = x + random.nextInt(16);
            int randZ = z + random.nextInt(16);
            int randY = world.getHeightValue(randX, randZ);
            BiomeGenBase biome = world.getBiomeGenForCoords(randX, randZ);
            if (biome != BiomeGenBase.river &&
                    biome != BiomeGenBase.ocean)
            {
                Block block = world.getBlock(randX, randY - 1, randZ);
                if (block != Blocks.water && block != Blocks.lava && block != Blocks.leaves)
                {
                    buildFlag(world, randX, randY, randZ, random);
                }
            }
        }
    }

    private void buildFlag(World world, int x, int y, int z, Random random)
    {
        for(int i = 0; i < 10; i++)
        {
            world.setBlock(x, y + i, z, Blocks.fence, 0 , 2);
        }
        int direction = random.nextInt(4);
        switch(direction)
        {
            case 0:
                for (int fx = 0; fx < 3; fx++)
                {
                    for (int fy = 0; fy < 3; fy++)
                    {
                        world.setBlock(x + 1 + fx, y + 7 + fy, z, ModBlocks.dutchFlag);
                    }
                }
                break;
            case 1:
                for (int fx = 0; fx < 3; fx++)
                {
                    for (int fy = 0; fy < 3; fy++)
                    {
                        world.setBlock(x - 1 - fx, y + 7 + fy, z, ModBlocks.dutchFlag);
                    }
                }
                break;
            case 2:
                for (int fx = 0; fx < 3; fx++)
                {
                    for (int fy = 0; fy < 3; fy++)
                    {
                        world.setBlock(x, y + 7 + fy, z + 1 + fx, ModBlocks.dutchFlag);
                    }
                }
                break;
            case 3:
                for (int fx = 0; fx < 3; fx++)
                {
                    for (int fy = 0; fy < 3; fy++)
                    {
                        world.setBlock(x, y + 7 + fy, z - 1 - fx, ModBlocks.dutchFlag);
                    }
                }
                break;
        }
    }

    private void generateFlagOre(World world, int x, int z, Random random)
    {
        for(int i = 0; i < 5; i++)
        {
            int randX = x + random.nextInt(16);
            int randZ = z + random.nextInt(16);
            int randY = 10 + random.nextInt(30);
            flagOre.generate(world, random, randX, randY, randZ);
        }

    }
}
