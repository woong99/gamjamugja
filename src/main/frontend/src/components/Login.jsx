import React, { useRef } from 'react';
import { Button, Col, Container, FloatingLabel, Form, Row } from 'react-bootstrap';
import { useDispatch } from 'react-redux';
import { useNavigate } from 'react-router-dom';
import { login } from '../redux/modules/auth';
import moduleStyle from '../pages/AuthPage.module.scss';
const Login = () => {
  const dispatch = useDispatch();
  const navigate = useNavigate();
  const email = useRef('');
  const password = useRef('');
  const onChange = (e, type) => {
    type.current = e.target.value;
  };
  const handleSubmit = (e) => {
    e.preventDefault();
    const signInData = { email: email.current, password: password.current };
    dispatch(login(signInData)).then((res) =>
      res.payload ? navigate('/') : console.log('로그인 실패'),
    );
  };
  const onSignUp = () => {
    navigate('/signup');
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
                    <div className="d-grid">
                      <Button
                        size="lg"
                        variant="primary"
                        type="submit"
                        className={`${moduleStyle.btnLogin} text-uppercase fw-bold mb-2 `}
                      >
                        Log In
                      </Button>
                      <Button
                        size="lg"
                        varient="primary"
                        type="submit"
                        className={`${moduleStyle.btnLogin} text-uppercase fw-bold mb-2 `}
                        onClick={onSignUp}
                      >
                        Sign Up
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

export default Login;
