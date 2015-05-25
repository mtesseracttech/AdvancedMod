package com.mtesseract.advancedmod.tileentity;

import net.minecraft.block.material.Material;

import java.util.Random;

/**
 * Created in IntelliJ IDEA
 * User: mtesseract
 * Project: AdvancedMod
 * Date: 18-05-15
 * Time: 16:08
 */
public class TileEntitySpoutLava extends TileEntityAdvancedMod
{
    private int totalLavaInMB = addLava();
    public String lavaQuantity = "Amount of Lava in Reservoir: " + totalLavaInMB;


    public TileEntitySpoutLava()
    {

    }

    private int addLava()
    {
        Random random = new Random();
        if(random.nextInt(10) == 0)
        {
            return generateLargeSpout(random);
        }
        else
        {
            return generateNormalSpout(random);
        }
    }

    private int generateLargeSpout(Random random)
    {
        return 1000000 + random.nextInt(10000000);
    }

    private int generateNormalSpout(Random random)
    {
        return 100000 + random.nextInt(1000000);
    }


    public int getTotalLavaInMB()
    {
        return totalLavaInMB;
    }

    public void setTotalLavaInMB(int totalLavaInMB)
    {
        this.totalLavaInMB = totalLavaInMB;
    }

}
