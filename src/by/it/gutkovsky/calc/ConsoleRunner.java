package by.it.gutkovsky.calc;

import java.util.Scanner;

class ConsoleRunner {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Parser parser = new Parser();
        Printer printer = new Printer();
        Logger logger = new Logger();
        printer.loadFromMemory(parser);

        ResMan res = ResMan.INSTANCE;
//        if(args.length==2){
//            Locale locale = new Locale(args[0], args[1]);
//            res.setLocale(locale);
//        }

        label:
        for (; ; ) {
            String expression = sc.nextLine();
            logger.logger(expression);

            switch (expression) {
                case "end":
                    break label;
                case "printvar":  // jd01_11 - taskB part2 // also print var from memory
                    printer.printVar();
                    break;
                case "sortvar":  // jd01_11 - taskC part2
                    printer.sortVar();
                    break;
                case "printmemory":
                    System.out.println("\033[33mSaved vars: \033[30m");
//                    System.out.println("\tSaved vars:");
                    printer.printFromMemory();
                    break;
                case "clearmemory":
                    try {
                        printer.cleanMemory();
                    } catch (CalcException e) {
                        e.printStackTrace();
                    }
                    break;
                default:

                    try {
                        Var var = parser.calc(expression);
                        printer.saveToMemory();
                        printer.print(var);
                        logger.logger(var.toString());
                    } catch (CalcException e) {
                        System.out.println(e.getMessage());
                        logger.logger(e.getMessage());
                    }
                    break;
            }
        }
    }
}
