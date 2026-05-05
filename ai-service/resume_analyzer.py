import re

def analyze_resume(text):
    score = 0
    feedback = []

    # Length check
    if len(text) > 100:
        score += 30
    else:
        feedback.append("Resume content is too short")

    # Skills detection
    skills = ["java", "python", "react", "sql", "spring"]
    found_skills = [skill for skill in skills if skill in text.lower()]

    score += len(found_skills) * 10

    if not found_skills:
        feedback.append("No technical skills detected")

    # Email check
    if re.search(r'\S+@\S+', text):
        score += 10
    else:
        feedback.append("Email not found")

    # Final feedback
    if score > 70:
        overall = "Strong Resume 💪"
    elif score > 40:
        overall = "Average Resume 👍"
    else:
        overall = "Weak Resume ❌"

    return {
        "score": score,
        "skills_detected": found_skills,
        "feedback": feedback,
        "overall": overall
    }