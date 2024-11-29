import pygame
import random

pygame.init()

screen_width, screen_height = 300, 600
block_size = 30
screen = pygame.display.set_mode((screen_width, screen_height))
pygame.display.set_caption("Tetris")

# Cores
BLACK = (0, 0, 0)
WHITE = (255, 255, 255)
COLORS = [
    (255, 0, 0),   # Vermelho
    (0, 255, 0),   # Verde
    (0, 0, 255),   # Azul
    (255, 255, 0), # Amarelo
    (255, 165, 0), # Laranja
    (128, 0, 128), # Roxo
    (0, 255, 255)  # Ciano
]

# Formas das peças
SHAPES = [
    [[1, 1, 1, 1]],  # Linha
    [[1, 1, 1], [0, 0, 1]],  # L
    [[1, 1, 1], [1, 0, 0]],  # J
    [[1, 1], [1, 1]],  # Quadrado
    [[0, 1, 1], [1, 1, 0]],  # Z
    [[1, 1, 0], [0, 1, 1]],  # S
    [[0, 1, 0], [1, 1, 1]]   # T
]

class Piece:
    def __init__(self):
        self.shape = random.choice(SHAPES)
        self.color = random.choice(COLORS)
        self.x = int(screen_width / block_size / 2) - 1
        self.y = 0

    def rotate(self):
        self.shape = [list(row) for row in zip(*self.shape[::-1])]

class Tetris:
    def __init__(self):
        self.grid = [[None for _ in range(screen_width // block_size)] for _ in range(screen_height // block_size)]
        self.current_piece = Piece()
        self.next_piece = Piece()
        self.clock = pygame.time.Clock()
        self.running = True
        self.drop_time = 0
        self.fall_time = 70  # Tempo inicial de queda ajustado para 70
        self.level = 1
        self.score = 0
        self.lines_cleared = 0
        self.hold_piece = None

        # Inicializa fonte para texto
        self.font = pygame.font.SysFont("Arial", 24)

    def draw_grid(self):
        for x in range(0, screen_width, block_size):
            pygame.draw.line(screen, WHITE, (x, 0), (x, screen_height))
        for y in range(0, screen_height, block_size):
            pygame.draw.line(screen, WHITE, (0, y), (screen_width, y))

    def draw_piece(self, piece):
        for y, row in enumerate(piece.shape):
            for x, value in enumerate(row):
                if value:
                    pygame.draw.rect(screen, piece.color,
                                     (piece.x * block_size + x * block_size,
                                      piece.y * block_size + y * block_size,
                                      block_size, block_size))

    def check_collision(self, piece):
        for y, row in enumerate(piece.shape):
            for x, value in enumerate(row):
                if value:
                    if (x + piece.x < 0 or
                        x + piece.x >= screen_width // block_size or
                        y + piece.y >= screen_height // block_size or
                        self.grid[y + piece.y][x + piece.x]):
                        return True
        return False

    def merge_grid(self, piece):
        for y, row in enumerate(piece.shape):
            for x, value in enumerate(row):
                if value:
                    self.grid[y + piece.y][x + piece.x] = piece.color
    def clear_lines(self):
        lines_to_clear = []
        for y in range(len(self.grid)):
            if all(self.grid[y]):
                lines_to_clear.append(y)
        for y in lines_to_clear:
            del self.grid[y]
            self.grid.insert(0, [None for _ in range(screen_width // block_size)])
            self.score += 10  # Aumenta a pontuação
            self.lines_cleared += 1  # Aumenta o contador de linhas limpas
            
            # Aumenta o nível a cada 10 linhas limpas
            if self.lines_cleared % 10 == 0:
                self.level += 1
                self.fall_time = max(10, self.fall_time - 5)  # Reduz a velocidade a cada nível  # Aumenta a velocidade de queda

    def hold_piece_function(self):
        if self.hold_piece is None:
            self.hold_piece = self.current_piece
            self.current_piece = self.next_piece
            self.next_piece = Piece()
            # A nova peça começa do topo da tela
            self.current_piece.y = 0
        else:
            self.current_piece, self.hold_piece = self.hold_piece, self.current_piece
            # A nova peça começa do topo da tela
            self.current_piece.y = 0

    def draw_status(self):
        level_text = self.font.render(f"Level: {self.level}", True, WHITE)
        speed_text = self.font.render(f"Speed: {self.fall_time}", True, WHITE)
        screen.blit(level_text, (10, 10))
        screen.blit(speed_text, (10, 40))

    def main(self):
        while self.running:
            screen.fill(BLACK)
            self.draw_grid()
            self.draw_piece(self.current_piece)
            self.draw_status() 
            for event in pygame.event.get():
                if event.type == pygame.QUIT:
                    self.running = False
                if event.type == pygame.KEYDOWN:
                    if event.key == pygame.K_LEFT:
                        self.current_piece.x -= 1
                        if self.check_collision(self.current_piece):
                            self.current_piece.x += 1
                    elif event.key == pygame.K_RIGHT:
                        self.current_piece.x += 1
                        if self.check_collision(self.current_piece):
                            self.current_piece.x -= 1
                    elif event.key == pygame.K_DOWN:
                        self.current_piece.y += 1
                        if self.check_collision(self.current_piece):
                            self.current_piece.y -= 1
                    elif event.key == pygame.K_UP:
                        self.current_piece.rotate()
                        if self.check_collision(self.current_piece):
                            self.current_piece.rotate()
                            self.current_piece.rotate()
                            self.current_piece.rotate()
                    elif event.key == pygame.K_SPACE:  # Guardar a peça
                        self.hold_piece_function()

            self.drop_time += self.clock.get_rawtime()
            if self.drop_time > self.fall_time:
                self.current_piece.y += 1
                if self.check_collision(self.current_piece):
                    self.current_piece.y -= 1
                    self.merge_grid(self.current_piece)
                    self.clear_lines()
                    self.current_piece = self.next_piece
                    self.next_piece = Piece()
                    # Iniciar a queda da nova peça imediatamente
                    if self.check_collision(self.current_piece):
                        print("Game Over!")
                        self.running = False
                self.drop_time = 0

            for y in range(len(self.grid)):
                for x in range(len(self.grid[y])):
                    if self.grid[y][x]:
                        pygame.draw.rect(screen, self.grid[y][x],
                                         (x * block_size, y * block_size, block_size, block_size))

            pygame.display.flip()
            self.clock.tick(60)

if __name__ == "__main__":
    Tetris().main()
