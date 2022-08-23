package top.cuteworld.tds;

import java.util.List;

public class NeuralNetworkRun {

    static double[][] X = {{0, 0}, {1, 0}, {0, 1}, {1, 1}};
    static double[][] Y = {{0}, {1}, {1}, {0}};

    public static void main(String[] args) {

        /**
         *  i=2 表示两个输入参数， 对应 {0,0}, {1,0}
         *  h=5 表示hidden layer有5个neuron 5个神经元
         *  o=1 表示输出偏置
         */
        NeuralNetwork nn = new NeuralNetwork(2, 1, 1);
        nn.fit(X, Y, 2000000);

        //
        //
        System.out.println("shape");
        double[][] input = {{0, 0}, {0, 1}, {1, 0}, {1, 1}};
        for (double d[] : input) {
            List<Double> output = nn.predict(d);
            System.out.println(output.toString());
        }//Output
    }
}
