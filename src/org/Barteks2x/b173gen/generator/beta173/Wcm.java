// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode 

package org.Barteks2x.b173gen.generator.beta173;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import net.minecraft.server.BiomeBase;
import net.minecraft.server.ChunkPosition;

// Referenced classes of package net.minecraft.src:
//            NoiseGeneratorOctaves2, World, ChunkCoordIntPair, BiomeGenBase

public class Wcm extends net.minecraft.server.WorldChunkManager {
    @SuppressWarnings("rawtypes")
    private List biomesToSpawn;

    @SuppressWarnings({ "rawtypes", "unchecked" })
    protected Wcm() {
	this.biomesToSpawn = new ArrayList();
	this.biomesToSpawn.add(BiomeGenBase.forest);
	this.biomesToSpawn.add(BiomeGenBase.rainforest);
	this.biomesToSpawn.add(BiomeGenBase.seasonalForest);
	this.biomesToSpawn.add(BiomeGenBase.taiga);
	this.biomesToSpawn.add(BiomeGenBase.tundra);
	this.biomesToSpawn.add(BiomeGenBase.plains);
    }

    public Wcm(long seed) {
	this();
	e = new NoiseGeneratorOctaves2(new Random(seed * 9871L), 4);
	f = new NoiseGeneratorOctaves2(new Random(seed * 39811L), 4);
	g = new NoiseGeneratorOctaves2(new Random(seed * 0x84a59L), 2);
    }

    @Override
    public BiomeGenBase getBiome(int i, int j) {
	return getBiomeData(i, j, 1, 1)[0];
    }

    @Override
    public float[] getWetness(float[] ad, int i, int j, int k, int l) {
	if (ad == null || ad.length < k * l)
	{
	    ad = new float[k * l];
	}
	double[] ad2 = new double[ad.length];
	for (int ii = 0; ii < ad.length; ii++) {
	    ad2[ii] = ad[ii];
	}
	ad2 = e.func_4112_a(ad2, i, j, k, l, 0.02500000037252903D, 0.02500000037252903D, 0.25D);
	c = g.func_4112_a(c, i, j, k, l, 0.25D, 0.25D, 0.58823529411764708D);
	int i1 = 0;
	for (int j1 = 0; j1 < k; j1++)
	{
	    for (int k1 = 0; k1 < l; k1++)
	    {
		double d = c[i1] * 1.1000000000000001D + 0.5D;
		double d1 = 0.01D;
		double d2 = 1.0D - d1;
		double d3 = (ad2[i1] * 0.14999999999999999D + 0.69999999999999996D) * d2 + d * d1;
		d3 = 1.0D - (1.0D - d3) * (1.0D - d3);
		if (d3 < 0.0D)
		{
		    d3 = 0.0D;
		}
		if (d3 > 1.0D)
		{
		    d3 = 1.0D;
		}
		ad2[i1] = d3;
		i1++;
	    }

	}
	for (int ii = 0; ii < ad.length; ii++) {
	    ad[ii] = (float) ad2[ii];
	}
	return ad;
	/*getBiomeData(b, c, d, e);

	float[] tempTemp = new float[this.rain.length];
	for (int x = 0; x < this.rain.length; ++x) {
	    tempTemp[x] = (float) this.rain[x];
	}

	return tempTemp;*/
    }

    @Override
    public float[] getTemperatures(float[] ad, int i, int j, int k, int l) {
	if (ad == null || ad.length < k * l)
	{
	    ad = new float[k * l];
	}
	double[] ad2 = new double[ad.length];
	for (int ii = 0; ii < ad.length; ii++) {
	    ad2[ii] = ad[ii];
	}
	ad2 = e.func_4112_a(ad2, i, j, k, l, 0.02500000037252903D, 0.02500000037252903D, 0.25D);
	c = g.func_4112_a(c, i, j, k, l, 0.25D, 0.25D, 0.58823529411764708D);
	int i1 = 0;
	for (int j1 = 0; j1 < k; j1++)
	{
	    for (int k1 = 0; k1 < l; k1++)
	    {
		double d = c[i1] * 1.1000000000000001D + 0.5D;
		double d1 = 0.01D;
		double d2 = 1.0D - d1;
		double d3 = (ad2[i1] * 0.14999999999999999D + 0.69999999999999996D) * d2 + d * d1;
		d3 = 1.0D - (1.0D - d3) * (1.0D - d3);
		if (d3 < 0.0D)
		{
		    d3 = 0.0D;
		}
		if (d3 > 1.0D)
		{
		    d3 = 1.0D;
		}
		ad2[i1] = d3;
		i1++;
	    }

	}
	for (int ii = 0; ii < ad.length; ii++) {
	    ad[ii] = (float) ad2[ii];
	}
	this.temperature = ad2;
	return ad;
	/*getBiomeData(b, c, d, e);

	float[] tempTemp = new float[this.temperature.length];
	for (int x = 0; x < this.temperature.length; ++x) {
	    tempTemp[x] = (float) this.temperature[x];
	}

	return tempTemp;*/
    }

    @Override
    public BiomeBase[] getBiomeBlock(BiomeBase abiomegenbase[], int i, int j, int k, int l) {
	if (abiomegenbase == null || abiomegenbase.length < k * l) {
	    abiomegenbase = new BiomeGenBase[k * l];
	}
	temperature = e.func_4112_a(temperature, i, j, k, k, 0.02500000037252903D, 0.02500000037252903D, 0.25D);
	rain = f.func_4112_a(rain, i, j, k, k, 0.05000000074505806D, 0.05000000074505806D, 0.33333333333333331D);
	c = g.func_4112_a(c, i, j, k, k, 0.25D, 0.25D, 0.58823529411764708D);
	int i1 = 0;
	for (int j1 = 0; j1 < k; j1++) {
	    for (int k1 = 0; k1 < l; k1++) {
		double d = c[i1] * 1.1000000000000001D + 0.5D;
		double d1 = 0.01D;
		double d2 = 1.0D - d1;
		double d3 = (temperature[i1] * 0.14999999999999999D + 0.69999999999999996D) * d2 + d * d1;
		d1 = 0.002D;
		d2 = 1.0D - d1;
		double d4 = (rain[i1] * 0.14999999999999999D + 0.5D) * d2 + d * d1;
		d3 = 1.0D - (1.0D - d3) * (1.0D - d3);
		if (d3 < 0.0D) {
		    d3 = 0.0D;
		}
		if (d4 < 0.0D) {
		    d4 = 0.0D;
		}
		if (d3 > 1.0D) {
		    d3 = 1.0D;
		}
		if (d4 > 1.0D) {
		    d4 = 1.0D;
		}
		temperature[i1] = d3;
		rain[i1] = d4;
		abiomegenbase[i1++] = BiomeGenBase.getBiomeFromLookup(d3, d4);
	    }

	}

	return abiomegenbase;
    }

    @Override
    public BiomeGenBase[] getBiomes(BiomeBase abiomegenbase[], int i, int j, int k, int l) {
	if (abiomegenbase == null || abiomegenbase.length < k * l) {
	    abiomegenbase = new BiomeGenBase[k * l];
	}
	temperature = e.func_4112_a(temperature, i, j, k, k, 0.02500000037252903D, 0.02500000037252903D, 0.25D);
	rain = f.func_4112_a(rain, i, j, k, k, 0.05000000074505806D, 0.05000000074505806D, 0.33333333333333331D);
	c = g.func_4112_a(c, i, j, k, k, 0.25D, 0.25D, 0.58823529411764708D);
	int i1 = 0;
	for (int j1 = 0; j1 < k; j1++) {
	    for (int k1 = 0; k1 < l; k1++) {
		double d = c[i1] * 1.1000000000000001D + 0.5D;
		double d1 = 0.01D;
		double d2 = 1.0D - d1;
		double d3 = (temperature[i1] * 0.14999999999999999D + 0.69999999999999996D) * d2 + d * d1;
		d1 = 0.002D;
		d2 = 1.0D - d1;
		double d4 = (rain[i1] * 0.14999999999999999D + 0.5D) * d2 + d * d1;
		d3 = 1.0D - (1.0D - d3) * (1.0D - d3);
		if (d3 < 0.0D) {
		    d3 = 0.0D;
		}
		if (d4 < 0.0D) {
		    d4 = 0.0D;
		}
		if (d3 > 1.0D) {
		    d3 = 1.0D;
		}
		if (d4 > 1.0D) {
		    d4 = 1.0D;
		}
		temperature[i1] = d3;
		rain[i1] = d4;
		abiomegenbase[i1++] = BiomeGenBase.getBiomeFromLookup(d3, d4);
	    }

	}
	return (BiomeGenBase[]) abiomegenbase;
    }

    private BiomeGenBase[] getBiomeData(int i, int j, int k, int l) {
	this.dx = getBiomes(this.dx, i, j, k, l);
	return this.dx;
    }

    private NoiseGeneratorOctaves2 e;
    private NoiseGeneratorOctaves2 f;
    private NoiseGeneratorOctaves2 g;
    public double		  temperature[];
    public double		  rain[];
    public double		  c[];
    public BiomeGenBase	    dx[];

    // ////////////////////////

    @Override
    public BiomeGenBase[] a(BiomeBase[] arg0, int arg1, int arg2, int arg3, int arg4, boolean arg5) {
	return getBiomes(arg0, arg1, arg2, arg3, arg4);
    }

    @SuppressWarnings("rawtypes")
    @Override
    public boolean a(int arg0, int arg1, int arg2, List arg3) {//areBiomesVisible
	return true;
    }

    @SuppressWarnings("rawtypes")
    @Override
    public ChunkPosition a(int par1, int par2, int par3, List par4List, Random par5Random) {
	return new ChunkPosition(0, 0, 0);//TODO
    }

    @Override
    @SuppressWarnings("rawtypes")
    public List a() {//getBiomesToSpawnIn
	return this.biomesToSpawn;
    }
}