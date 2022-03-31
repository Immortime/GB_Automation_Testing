public class Triangle {
    public static Double SquareTriangle (double a, double b, double c) throws Exception {
        if (a <= 0 || b <= 0 || c <= 0) {
            throw new BadMathSkillsException();
        }
        double halfper = (a + b + c) / 2;
        double square = Math.sqrt(halfper * (halfper - a) * (halfper - b) * (halfper - c));
        return square;
    }
}
