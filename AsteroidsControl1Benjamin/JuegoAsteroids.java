import greenfoot.*;
import java.util.List;

public class JuegoAsteroids extends World {

    private static final int FPS = 60;          // aprox Greenfoot
    private static final int MIN_DIST = 160;    // distancia mínima nave–asteroide
    private static final int MAX_ASTEROIDES = 20; // máximo simultáneos
    private static final int INTERVALO = 15 * FPS; // 15 segundos en frames

    private int spawnTimer = 0;

    public JuegoAsteroids() {
        super(900, 700, 1);
        prepare();
    }

    private void prepare() {
        Nave nave = new Nave();
        addObject(nave, getWidth()/2, getHeight()/2);

        // Spawnea algunos al inicio
        for (int i = 0; i < 5; i++) {
            spawnAsteroideLejos(nave);
        }
    }

    public void act() {
        spawnTimer++;

        // Cada 15 segundos exactos
        if (spawnTimer >= INTERVALO) {
            Nave nave = obtenerNave();

            // Generar 3 grandes de golpe
            for (int i = 0; i < 3; i++) {
                if (getObjects(AsteroideGrande.class).size() < MAX_ASTEROIDES) {
                    spawnAsteroideLejos(nave);
                }
            }

            spawnTimer = 0; // reinicia contador
        }
    }

    // -------- helpers --------
    private void spawnAsteroideLejos(Nave nave) {
        int x, y, intentos = 0;
        do {
            x = Greenfoot.getRandomNumber(getWidth());
            y = Greenfoot.getRandomNumber(getHeight());
            intentos++;
        } while (nave != null &&
                 dist2(x, y, nave.getX(), nave.getY()) < MIN_DIST*MIN_DIST &&
                 intentos < 100);

        AsteroideGrande a = new AsteroideGrande();
        addObject(a, x, y);
        a.direccionAsteroide(); // rumbo aleatorio
    }

    private int dist2(int x1, int y1, int x2, int y2) {
        int dx = x1 - x2, dy = y1 - y2;
        return dx*dx + dy*dy;
    }

    private Nave obtenerNave() {
        List<Nave> n = getObjects(Nave.class);
        return n.isEmpty() ? null : n.get(0);
    }
}
