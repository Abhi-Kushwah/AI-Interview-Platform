from flask import Flask, request, jsonify
from resume_analyzer import analyze_resume
from speech_analysis import analyze_speech

app = Flask(__name__)

@app.route('/')
def home():
    return "AI Service Running 🚀"

# Resume Analyzer API
@app.route('/analyze/resume', methods=['POST'])
def resume_api():
    data = request.json
    text = data.get("text", "")

    result = analyze_resume(text)

    return jsonify(result)

# Speech Analyzer API
@app.route('/analyze/speech', methods=['POST'])
def speech_api():
    data = request.json
    text = data.get("text", "")

    result = analyze_speech(text)

    return jsonify(result)

if __name__ == '__main__':
    app.run(debug=True, port=5000)