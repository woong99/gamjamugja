import React, { useRef } from 'react';
import { Button, Col, Container, FloatingLabel, Row, Form } from 'react-bootstrap';
import { useDispatch } from 'react-redux';
import { useNavigate } from 'react-router-dom';
import { login, signUp } from '../redux/modules/auth';
import moduleStyle from '../pages/AuthPage.module.scss';
const SignUp = () => {
  const dispatch = useDispatch();
  const navigate = useNavigate();
  const email = useRef('');
  const password = useRef('');
  const nickname = useRef('');
  const onChange = (e, type) => {
    type.current = e.target.value;
  };
  const handleSubmit = (e) => {
    e.preventDefault();
    const signInData = {
      email: email.current,
      password: password.current,
      nickname: nickname.current,
    };
    dispatch(signUp(signInData)).then((res) =>
      res.payload ? navigate('/') : alert('회원가입 실패'),
    );
  };
  return (
    <Container fluid className="ps-md-0">
      <Row className="g-0">
        <div className={`${moduleStyle.bgImage} d-none d-md-flex col-md-4 col-lg-6`}></div>
        <Col md={8} lg={6}>
          <div className={`${moduleStyle.login} d-flex align-items-center py-5`}>
            <Container>
              <Row>
                <Col md={9} lg={8} className="mx-auto">
                  <h3 className={`${moduleStyle.loginHeading} mb-4`}>Potato Woong</h3>
                  <Form onSubmit={handleSubmit}>
                    <FloatingLabel className="mb-3" label="Email address" controlId="floatingInput">
                      <Form.Control
                        type="email"
                        placeholder="name@example.com"
                        onChange={(e) => onChange(e, email)}
                      />
                    </FloatingLabel>
                    <FloatingLabel className="mb-3" label="Password" controlId="floatingPassword">
                      <Form.Control
                        type="password"
                        placeholder="Password"
                        onChange={(e) => onChange(e, password)}
                      />
                    </FloatingLabel>
                    <FloatingLabel className="mb-3" label="Nickname" controlId="floatingNickname">
                      <Form.Control
                        type="text"
                        placeholder="Nickname"
                        onChange={(e) => onChange(e, nickname)}
                      />
                    </FloatingLabel>
                    <div className="d-grid">
                      <Button
                        size="lg"
                        variant="primary"
                        type="submit"
                        className={`${moduleStyle.btnLogin} text-uppercase fw-bold mb-2 `}
                      >
                        Sign in
                      </Button>
                    </div>
                  </Form>
                </Col>
              </Row>
            </Container>
          </div>
        </Col>
      </Row>
    </Container>
  );
};

export default SignUp;
