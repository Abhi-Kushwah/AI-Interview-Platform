def analyze_speech(text):
    words = text.split()
    word_count = len(words)

    filler_words = ["um", "uh", "like", "you know"]
    filler_count = sum(text.lower().count(word) for word in filler_words)

    confidence_score = max(0, 100 - filler_count * 10)

    # Grammar (basic check)
    grammar_score = 100 if text.endswith('.') else 70

    # Final scoring
    overall_score = (confidence_score + grammar_score) // 2

    feedback = []

    if filler_count > 2:
        feedback.append("Too many filler words")

    if not text.endswith('.'):
        feedback.append("Sentence not properly ended")

    if overall_score > 75:
        level = "High Confidence 🔥"
    elif overall_score > 50:
        level = "Moderate 👍"
    else:
        level = "Low Confidence ❌"

    return {
        "confidence_score": confidence_score,
        "grammar_score": grammar_score,
        "overall_score": overall_score,
        "level": level,
        "feedback": feedback
    }