package techguns.util;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.ResourceLocation;

public class MBlock implements Serializable {
	
	private static final long serialVersionUID = 1L;	
	
	public transient Block block;
	public int meta;
	protected IBlockState state;

	public MBlock(IBlockState state) {
		this.block = state.getBlock();
		this.meta = block.getMetaFromState(state);
		this.state=state;
	}

	public MBlock(Block block, int meta) {
		this.block = block;
		this.meta = meta;
		this.state = block.getStateFromMeta(meta);
	}

	public IBlockState getState() {
		return state;
	}
	
	@Override
	public boolean equals(Object other) {
		return (other instanceof MBlock) && ((MBlock) other).block == this.block && ((MBlock) other).meta == this.meta;
	}

	private void writeObject(ObjectOutputStream out) throws IOException {
		out.defaultWriteObject();
		ResourceLocation name = block.getRegistryName();
		out.writeUTF(name.toString());
		//out.writeInt(meta);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((block == null) ? 0 : block.getRegistryName().hashCode());
		result = prime * result + meta;
		return result;
	}


	private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
		in.defaultReadObject();
		String name = in.readUTF();
		this.block = Block.getBlockFromName(name);
		//this.meta = in.read();
	}

}
