import java.io.IOException;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;


public class StoreMap extends Mapper<LongWritable,Text,Text,NullWritable> {
	public void setup(Context context)
	{
		try {
			context.write(new Text("title,brand,store,price,in_stock"), NullWritable.get());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void map(LongWritable key,Text value,Context context){
		if (Long.parseLong(key.toString()) == 0)
			return;
		else{
		String[] val = value.toString().split(",");
		int store = Integer.parseInt(val[2]);
		String brand = ( val[0] + ',' +val[1] + ',' + val[2] + ',' + val[3] + ',' +val[4]);
		if (store == 2){
		try {
			context.write(new Text(brand),NullWritable.get());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
	}
	}
}
