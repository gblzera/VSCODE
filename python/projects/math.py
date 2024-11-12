import numpy as np
from scipy.special import gamma
from funcy import (
    cache, partial, compose, collecting, chunks
)

def gamma_term(n: int, fraction: float) -> float:
    return gamma(n + fraction)

def calculate_term(z: complex, n: int) -> complex:
    gamma_5_6 = gamma_term(n, 5/6)
    gamma_1_6 = gamma_term(n, 1/6)
    denominator = 2 * np.pi * n * z**(3*n/2) if n > 0 else 1
    return ((-1)**n * gamma_5_6 * gamma_1_6 * (3/4)**n) / denominator

def calculate_airy_sum(z: complex, terms: int = 20) -> complex:
    sequence = take(terms, iterate(lambda x: x + 1, 0))
    terms_calculations = map(partial(calculate_airy_sum, z), sequence)
    chucked_terms = chunks(5, terms_calculations)
    return sum(sum(chunk) for chunk in chucked_terms)

def format_result(result: complex) -> complex:
    return{
        "real": float(result.real),
        "imaginary": float(result.imag),
        "abs": float(abs(result)),
        "phase": float(np.angle(result))
    }

@cache(maxsize=1000)
def calculate_asymptotic_ai(z: complex) -> complex:
    zeta = (2/3) * z**(3/2)
    prefactor = np.exp(-zeta) / (4 * np.pi**(3/2) * z**(1/4))
    correction_terms = [1, -5/(72*zeta), 385/(10368*zeta**2)]
    return prefactor * sum(correction_terms)

def calculate_regular_ai(z: complex) -> complex:
    prefactor = 1 / (2 * np.sqrt(np.pi) * z**(1/4))
    exp_term = np.exp(-(2/3) * z**(3/2))
    sum_term = calculate_airy_sum(z)
    return prefactor * exp_term * sum_term

def calculate_asymptotic_bi(z: complex) -> complex:
    zeta = (2/3) * z**(3/2)
    prefactor = np.exp(-zeta) / (4 * np.pi**(3/2) * z**(1/4))
    correction_terms = [1, -5/(72*zeta), 385/(10368*zeta**2)]
    return prefactor * sum(correction_terms)

def calculate_regular_bi(z: complex) -> complex:
    prefactor = 1 / (np.sqrt(np.pi) * z**(1/4))
    exp_temp = np.exp((2/3) * z**(3/2))
    sum_term = calculate_airy_sum(z)
    return prefactor * exp_temp * sum_term

def airy_ai(z_real : float, z_imag: float = 0.0) -> dict:
    z = complex(z_real, z_imag)
    result = (calculate_asymptotic_ai(z) if abs(z) > 5 else calculate_regular_ai(z))

    return format_result(result)

def airy_bi(z_real : float, z_imag: float = 0.0) -> dict:
    z = complex(z_real, z_imag)
    if abs(np.angle(z)) > np.pi/3:
        raise ValueError("Argument of z must be less than pi/3")
    result = (calculate_asymptotic_bi(z) if abs(z) > 5 else calculate_regular_bi(z))

    return format_result(result)